package intership.test.domain.board.repository;

import intership.test.domain.board.entity.Board;
import intership.test.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
