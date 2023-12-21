package salad_a_zoom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasket {

    @Id
    @GeneratedValue
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_userNo")
    private Member member;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumns({
            @JoinColumn( name="items_itemNm"),
            @JoinColumn(name ="items_id")})
    private Items items;

    @Transient
    private String filePath;

    @Transient
    private String fileUrl;

    @Transient
    private String[] thumbsPath;

    @Transient
    private String[] thumbsUrl;
}
