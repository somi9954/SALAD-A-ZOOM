package salad_a_zoom.commons.validators;

/**
 * 핸드폰 번호 검증
 */
public interface MobileValidator {

    default boolean mobileNumCheck(String mobile) {
        /**
         * 010-2331-1354
         * 010_2331_1354
         * 010 2331 1354
         * 1. 형식의 통일화 - 숫자가 아닌 문자 전부 제거 -> 숫자
         * 2. 패턴 생성 체크
         */
        mobile = mobile.replaceAll("\\D", "");
        String pattern = "^01[016]\\d{3,4}\\d{4}$";

        return mobile.matches(pattern);
    }
}
