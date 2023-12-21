package salad_a_zoom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import salad_a_zoom.commons.constants.Status;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseGoods {

    @Id
    private Long OrderId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumns({
            @JoinColumn( name="items_seq"),
            @JoinColumn( name="items_bId"),
            @JoinColumn( name="items_userNo"),
            @JoinColumn( name="items_id"),
            @JoinColumn(name ="items_itemNm")})
    private Items items;

    @Transient
    private String filePath;

    @Transient
    private String fileUrl;

    @Transient
    private String[] thumbsPath;

    @Transient
    private String[] thumbsUrl;

    @Column(nullable = false)
    private Long totalPrice;

    @Column(nullable = false)
    private String deliveryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_value")
    @Column(nullable = false)
    private Status status;
}
