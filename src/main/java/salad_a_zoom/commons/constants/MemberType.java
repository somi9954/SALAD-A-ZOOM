package salad_a_zoom.commons.constants;


import java.util.Arrays;
import java.util.List;


public enum MemberType {
    GUEST(false, "비회원"), // 전체사용자
    USER(true, "회원"), // 일반회원
    ADMIN(true, "관리자"); // 관리자

    // 영어를 한국어로 수정
    private final String title;

    // 가입 시 동의 여부
    private final boolean agree;

    MemberType(boolean agree, String title) {
        this.agree = agree;
        this.title = title;
    }

    public static List<Object[]> getList() {
        return Arrays.asList(
                new Object[]{GUEST.name(), GUEST.title, GUEST.agree},
                new Object[]{USER.name(), USER.title, USER.agree},
                new Object[]{ADMIN.name(), ADMIN.title, ADMIN.agree}
        );
    }

    public String getTitle() {
        return title;
    }

    public boolean getAgree() {
        return agree;
    }
}
