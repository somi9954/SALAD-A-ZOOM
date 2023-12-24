package salad_a_zoom.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import salad_a_zoom.commons.exceptions.CommonException;

@RestControllerAdvice("salad_a_zoom.api")
public class ApiCommonController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData<Object>> errorHandler(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Object message = e.getMessage();
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException)e;
            status = commonException.getStatus();
            if (commonException.getMessages() != null) message = commonException.getMessages();
        } else if (e instanceof BadCredentialsException) {
            status = HttpStatus.UNAUTHORIZED;
        } else if (e instanceof AccessDeniedException) {
            status = HttpStatus.FORBIDDEN;
        }

        JSONData<Object> data = new JSONData<>();
        data.setSuccess(false);
        data.setMessage(message);
        data.setStatus(status);

        e.printStackTrace();
        System.out.println(data);
        return ResponseEntity.status(status).body(data);
    }
}