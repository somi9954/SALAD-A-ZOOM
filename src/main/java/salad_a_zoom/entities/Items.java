package salad_a_zoom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Items extends Board {
    @Id
    @Column(length=50)
    private String sId;  // bId를 sId로 변경

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_bId")
    private Board board;

    @Id
    @GeneratedValue
    private Long seq;

    @Id @Column(length = 50, nullable = false)
    private String itemNm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="admin_userNo")
    private Admin admin;

    private Long stockNumber;

    @Column(nullable = false)
    private Long price;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fileInfo_id")
    @Column(length = 100, nullable = false)
    private FileInfo fileInfo;

    @Transient
    private String filePath;

    @Transient
    private String fileUrl;

    @Transient
    private String[] thumbsPath;

    @Transient
    private String[] thumbsUrl;

}
