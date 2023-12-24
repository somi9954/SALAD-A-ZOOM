package salad_a_zoom.repositories.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import salad_a_zoom.entities.BoardView;
import salad_a_zoom.entities.BoardViewId;

public interface BoardViewRepository extends JpaRepository<BoardView, BoardViewId>, QuerydslPredicateExecutor<BoardView> {
}