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
public class Notice extends Base {

    @Id
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "boardData_seq", referencedColumnName = "boardData_seq")
    private BoardData boardData;

    @Column(length=50, nullable = false)
    private String gid = UUID.randomUUID().toString();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bId")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn( name = "admin_userNo"),
            @JoinColumn(name = "admin_userNm")})
    private Admin admin;

    @Column(length=30, nullable = false)
    private String poster;

    @Column(length=65)
    private String guestPw; // 비회원 비밀번호

    @Column(nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    private boolean notice; // 공지사항 여부

    private int viewCnt; // 조회수

    @Transient
    private List<FileInfo> editorImages; // 이미지 첨부

    @Transient
    private List<FileInfo> attachFiles; // 파일 첨부
}
