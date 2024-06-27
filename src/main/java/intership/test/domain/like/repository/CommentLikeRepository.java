package intership.test.domain.like.repository;

import intership.test.domain.like.entity.CommentLike;
import intership.test.domain.like.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike, LikeId> {
}
