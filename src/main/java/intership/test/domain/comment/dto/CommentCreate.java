package intership.test.domain.comment.dto;

import intership.test.domain.board.entity.Board;
import intership.test.domain.user.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentCreate {

    @NotNull(message = "내용을 입력하지 않았습니다.")
    private String content;
    private Long user_id;
    private Long board_idx;

    @Builder

    public CommentCreate(String content, Long user_id, Long board_idx) {
        this.content = content;
        this.user_id = user_id;
        this.board_idx = board_idx;
    }
}
