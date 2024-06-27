package intership.test.domain.board.dto;

import intership.test.domain.user.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BoardCreate {
    @NotNull(message = "작성자는 공백이 될 수 없습니다.")
    private Long user_id;
    @NotNull(message = "제목을 입력하지 않았습니다.")
    private String title;
    @NotNull(message = "내용을 입력하지 않았습니다.")
    private String content;

    @Builder
    public BoardCreate(Long user_id, String title, String content) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
    }
}
