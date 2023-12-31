package salad_a_zoom.models.board;

import org.springframework.http.HttpStatus;
import salad_a_zoom.commons.exceptions.CommonException;

public class BoardDataNotFoundException extends CommonException {
    public BoardDataNotFoundException(String message) {
        super(Utils.getMessage("NotFound.boardData", "error"));
        setStatus(HttpStatus.NOT_FOUND);
    }
}
