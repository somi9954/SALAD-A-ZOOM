package salad_a_zoom.commons.constants;

public enum Status {
    BEFORE("주문 완료"),
    PREPARING("배송 준비"),
    DELIVERING("배송 중"),
    DELIVERED("배송 완료");

    private String value;

    Status(String value) {
        this.value = value;
    }
}
