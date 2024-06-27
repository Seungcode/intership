package intership.test.domain.like.entity;

import intership.test.domain.comment.entity.Comment;
import intership.test.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLike {
    @EmbeddedId
    private LikeId like_id;

    public CommentLike(LikeId id) {
        this.like_id = id;
    }

    public Comment pressLike(Comment comment, CommentLike commentLike){
        List<CommentLike> commentLikes = comment.getCommentLikes();
        if(!commentLikes.remove(commentLike)) {
            commentLikes.add(commentLike);
        }
        comment.updateCommentLike(commentLikes);
        return comment;
    }
}
