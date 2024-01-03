package salad_a_zoom.models.comment;

import org.springframework.http.HttpStatus;
import salad_a_zoom.commons.exceptions.CommonException;

public class CommentNotFoundException extends CommonException {
    public CommentNotFoundException() {
        super(Utils.getMessage("NotFound.comment", "error"));
        setStatus(HttpStatus.NOT_FOUND);
    }

}
