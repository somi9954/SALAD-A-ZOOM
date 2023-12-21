package salad_a_zoom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity @Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class QandA {
    @Id @GeneratedValue
    private Long seq;

    @Column(length=50, nullable = false)
    private String gid = UUID.randomUUID().toString();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userNo")
    private Member member;

    @Column(length=30, nullable = false)
    private String poster;

    @Column(length=65)
    private String guestPw; // 비회원 비밀번호

    @Column(length = 50, nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumns({
            @JoinColumn( name="items_seq"),
            @JoinColumn(name ="items_itemNm")})
    private Items items;


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumns({
            @JoinColumn( name="commentData_seq"),
            @JoinColumn(name ="commentData_poster"),
            @JoinColumn(name = "commentData_content")})
    private CommentData commentData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "parent_seq"),
            @JoinColumn(name ="parent_poster"),
            @JoinColumn(name = "parent_content")})
    private CommentData parent;


    @Lob
    @Column(nullable = false)
    private String reply;

    private int commentCnt; // 댓글 수

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QandA> replies; // 대댓글 목록

}
