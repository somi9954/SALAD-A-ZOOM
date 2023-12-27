package salad_a_zoom.api.board.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import salad_a_zoom.api.board.dto.BoardForm;


@Component
public class BoardFormValidator implements Validator {

    private final CustomJwtFilter customJwtFilter;

    @Override
    public boolean supports(Class<?> clazz) {
        return BoardForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BoardForm form = (BoardForm) target;

        /** 비회원 비밀번호 체크 S */
        if (!customJwtFilter.isUserLoggedIn()) { // 미로그인 상태 -> 비회원 비밀번호 필수

            String guestPw = form.getGuestPw();

            if (guestPw == null || guestPw.isBlank()) {
                errors.rejectValue("guestPw", "NotBlank");
            }

            if (guestPw != null && guestPw.length() < 6) {
                errors.rejectValue("guestPw", "Size");
            }
            /** 비회원 비밀번호 체크 E */
        }
    }
}
