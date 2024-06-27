package intership.test.domain.like.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CommentLikeCreate {
    private Long user_id;
    private Long comment_id;

    public CommentLikeCreate(Long user_id, Long comment_id) {
        this.user_id = user_id;
        this.comment_id = comment_id;
    }
}
