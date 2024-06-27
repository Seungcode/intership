package intership.test.domain.like.dto;

import intership.test.domain.comment.entity.Comment;
import intership.test.domain.like.entity.CommentLike;
import intership.test.domain.like.entity.LikeId;
import intership.test.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLikeMapper {
    public static CommentLike toCommentLike(User user, Comment comment){
        return new CommentLike(new LikeId(user, comment));
    }
}
