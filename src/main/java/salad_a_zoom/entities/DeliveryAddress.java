package salad_a_zoom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddress extends Base {

    @Id @GeneratedValue
    private Long seq;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="userNo")
    private Member member;

    @Lob
    @Column(nullable = false)
    private String address;
}
