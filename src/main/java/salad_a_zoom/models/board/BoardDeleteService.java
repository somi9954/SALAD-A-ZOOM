package salad_a_zoom.models.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import salad_a_zoom.entities.BoardData;
import salad_a_zoom.repositories.board.BoardDataRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardDeleteService {
    private final BoardInfoService infoService;
    private final BoardDataRepository repository;
    private final FileDeleteService fileDeleteService;

    public void delete(Long seq) {
        BoardData data = infoService.get(seq);
        String gid = data.getGid();

        // 파일 삭제
        fileDeleteService.deleteByGid(gid);

        // 게시글 삭제
        repository.delete(data);

        repository.flush();

    }
}