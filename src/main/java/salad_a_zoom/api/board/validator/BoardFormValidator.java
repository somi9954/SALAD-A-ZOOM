package salad_a_zoom.api.board.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import salad_a_zoom.api.board.dto.BoardForm;
import salad_a_zoom.commons.validators.Validator;

public class BoardFormValidator {
    @Component
    @RequiredArgsConstructor
    public class BoardFormValidator implements Validator {

        private final CustomJwtFilter customJwtFilter;

        @Override
        public boolean supports(Class<?> clazz) {
            return BoardForm.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            BoardForm boardForm = (BoardForm)target;
            /** 비회원 비밀번호 체크 S */
            Long id = boardForm.getId();
            Long userNo = boardForm.getUserNo();

            if ((id == null && !customJwtFilter.isUserLoggedIn())  // 글 작성시 비회원
                    || (id != null && userNo == null)) { // 글 수정시 비회원
                String guestPw = boardForm.getGuestPw();
                if (guestPw == null || guestPw.isBlank()) {
                    errors.rejectValue("guestPw", "NotBlank");
                }

                if (guestPw != null && guestPw.length() < 6) {
                    errors.rejectValue("guestPw", "Size");
                }
            }
            /** 비회원 비밀번호 체크 E */
        }
    }
}
