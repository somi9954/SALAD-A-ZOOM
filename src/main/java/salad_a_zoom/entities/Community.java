package salad_a_zoom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.FileInfo;

import java.util.List;
import java.util.UUID;

@Entity @Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Community extends Base {

    @Id @GeneratedValue
    private String seq;

    @Column(length=50, nullable = false)
    private String gid = UUID.randomUUID().toString();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bId")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn( name="member_userNo"),
            @JoinColumn(name = "member_userNm")})
    private Member member;

    @Column(length=30, nullable = false)
    private String poster;

    @Column(length=50)
    private String category;

    @Column(length = 50, nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    private int viewCnt; // 조회수

    private int commentCnt; // 댓글 수

    @Lob
    @Column(nullable = false)
    private String reply;

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

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Community> replies; // 대댓글 목록

    @Transient
    private List<FileInfo> editorImages; // 이미지 첨부

    @Transient
    private List<FileInfo> attachFiles; // 파일 첨부

}
