package intership.test.domain.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentCreate {

    private String content;
    private Long user_id;
    private Long board_idx;

    public CommentCreate(CommentGetReq commentGetReq, Long board_idx) {
        this.content = commentGetReq.getContent();
        this.user_id = commentGetReq.getUser_id();
        this.board_idx = board_idx;
    }
}
