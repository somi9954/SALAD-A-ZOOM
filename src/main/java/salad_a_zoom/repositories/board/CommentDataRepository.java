package salad_a_zoom.repositories.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import salad_a_zoom.entities.CommentData;

public interface CommentDataRepository extends JpaRepository<CommentData, Long>, QuerydslPredicateExecutor<CommentData> {

    /**
     * 게시글별 댓글 수
     * @param boardDataSeq
     * @return
     */
    default int getTotal(Long boardDataSeq) {
        QCommentData commentData = QCommentData.commentData;

        return (int)count(commentData.boardData.seq.eq(boardDataSeq));
    }
}