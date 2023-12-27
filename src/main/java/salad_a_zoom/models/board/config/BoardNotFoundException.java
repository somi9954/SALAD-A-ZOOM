package salad_a_zoom.models.board.config;

import org.springframework.http.HttpStatus;
import salad_a_zoom.commons.exceptions.CommonException;

public class BoardNotFoundException extends CommonException {

    public BoardNotFoundException(String message) {
        super(Utils.getMessage("NotFound.board", "error"));
        setStatus(HttpStatus.NOT_FOUND);
    }
}
