package salad_a_zoom.models.board.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import salad_a_zoom.api.board.dto.BoardForm;
import salad_a_zoom.entities.Board;
import salad_a_zoom.repositories.board.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardConfigDeleteService {
    private final BoardRepository repository;
    private final Utils utils;

    /**
     * 게시판 설정 삭제
     *
     * @param bId
     */

    public void delete(String bId) {
        Board board = repository.findById(bId).orElseThrow(() -> new BoardNotFoundException(bId));

        repository.delete(board);
        repository.flush();
    }

    /**
     * 목록에서 일괄 삭제
     *
     */
    public void delete(BoardForm boardForm, Errors errors) {
        if (idxes == null || idxes.isEmpty()) {

        }

        for (int idx : idxes) {
            String bId = utils.getParam("bId_" + idx);
            Board board = repository.findById(bId).orElse(null);
            if (board == null) continue;

            repository.delete(board);
        }

        repository.flush();
    }
}