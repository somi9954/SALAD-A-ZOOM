package salad_a_zoom.models.board;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import salad_a_zoom.api.board.dto.BoardForm;
import salad_a_zoom.api.board.validator.BoardFormValidator;
import salad_a_zoom.entities.Board;
import salad_a_zoom.entities.BoardData;
import salad_a_zoom.models.board.config.BoardConfigInfoService;
import salad_a_zoom.repositories.board.BoardDataRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardSaveService {
    private final BoardDataRepository boardDataRepository;
    private final BoardConfigInfoService infoService;
    private final MemberUtil memberUtil;
    private final PasswordEncoder encoder;
    private final FileInfoRepository fileInfoRepository;
    private final BoardFormValidator validator;

    public void save(BoardForm form, Errors errors) {
        validator.validate(form, errors);
        if (errors.hasErrors()) {
            return;
        }

        save(form);
    }

    public void save(BoardForm form) {
        Long seq = form.getSeq();
        String mode = Objects.requireNonNullElse(form.getMode(), "write");

        // 게시판 설정 조회 + 글쓰기 권한 체크
        Board board = infoService.get(form.getBId(), true);

        String gid = form.getGid();

        BoardData data = null;
        if (mode.equals("update") && seq != null) {
            data = boardDataRepository.findById(seq).orElseThrow(BoardDataNotFoundException::new);
        } else {
            data = new BoardData();
            data.setBoard(board); // 게시판 bId 최초 글 등록시 한번만 등록
            data.setGid(gid); // 그룹 ID(GID)는 최초 글 등록시 한번만 등록
            data.setMember(memberUtil.getMember()); // 글 등록 회원 정보도 최초 글등록시 한번
        }

        data.setSubject(form.getSubject());
        data.setContent(form.getContent());
        data.setPoster(form.getPoster());
        data.setCategory(form.getCategory());

        // 공지사항 여부 - 관리자만 등록, 수정
        if (memberUtil.isAdmin()) {
            data.setNotice(form.isNotice());
        }

        // 비회원 비밀번호 처리
        String guestPw = form.getGuestPw();
        if (StringUtils.hasText(guestPw)) {
            data.setGuestPw(encoder.encode(guestPw));
        }

        boardDataRepository.saveAndFlush(data);

        // 파일 업로드 완료 처리
        fileInfoRepository.processDone(gid);
    }
}