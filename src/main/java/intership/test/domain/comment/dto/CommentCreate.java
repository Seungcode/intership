package intership.test.domain.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CommentCreate {

    @NotNull(message = "내용을 입력하지 않았습니다.")
    private String content;
    private Long user_id;
    private Long board_idx;

    public CommentCreate(String content, Long user_id, Long board_idx) {
        this.content = content;
        this.user_id = user_id;
        this.board_idx = board_idx;
    }
}
