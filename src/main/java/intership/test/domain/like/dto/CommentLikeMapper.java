package intership.test.domain.like.dto;

import intership.test.domain.like.entity.CommentLike;
import intership.test.domain.like.entity.LikeId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLikeMapper {
    public static CommentLike toCommentLike(LikeId likeId){
        return new CommentLike(likeId);
    }
}
