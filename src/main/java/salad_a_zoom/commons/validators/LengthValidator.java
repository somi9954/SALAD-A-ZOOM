package salad_a_zoom.commons.validators;


/**
 * 자리수 체크
 * 비밀번호, 핸드폰 번호
 */
public interface LengthValidator {
    /**
     *
     * @param str 문자열
     * @param min 최소 문자 갯수 -> 0일때는 체크 X
     * @param max 최대 문자 갯수 -> 0일때는 체크 X
     */
    default void lengthCheck(String str, int min, int max, RuntimeException e) {
        if (str == null || (min > 0 && str.length() < min) || (max > 0 && str.length() > max)) {
            throw e;
        }
    }

    /**
     *
     * @param str 문자열
     * @param min 최소 문자 갯수 -> 0이면 체크
     *
     */
    default void lengthCheck(String str, int min, RuntimeException e) {
        lengthCheck(str, min, 0, e);
    }


    /**
     *
     * @param num 숫자
     * @param min num이 최소 값(min) 보다 큰 지 체크
     * @param max num이 최대 값(max) 보다 큰 지 체크
     *
     */
    default void lengthCheck(long num, int min, int max, RuntimeException e) {
        if (num < min || num > max) {
            throw e;
        }
    }

    /**
     *
     * @param num 숫자
     * @param min num이 최소값(min)보다 크거나 작은지 체크
     */

    default void lengthCheck(long num, int min, RuntimeException e) {
        if (num < min) {
            throw  e;
        }
    }
}
