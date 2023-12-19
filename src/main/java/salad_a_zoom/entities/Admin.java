package salad_a_zoom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import salad_a_zoom.commons.constants.MemberType;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Base {

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userNo")
    private Member member;

    // 보안 상 이유로 email, password 를 가져올 수 없다.( password의 경우 해쉬화가 되는데 데이터베이스에서 검색이 어려울 수 있어 외래키로 가져오는 대신 따로 엔티티를 만드는 방법이 옳다.
    @Column(length=50, unique = true, nullable = false)
    private String email;

    @Column(length=40, nullable = false)
    private String password;

    @Column(length=40, nullable=false)
    private String userNm;

    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable = false)
    private MemberType mtype = MemberType.ADMIN;

    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable = false)
    private MemberType agree = MemberType.ADMIN;
}
