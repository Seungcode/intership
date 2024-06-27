package intership.test.domain.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentGetReq {
    @NotNull(message = "내용을 입력하지 않았습니다.")
    private String content;

    private Long user_id;

    public CommentGetReq(String content, Long user_id) {
        this.content = content;
        this.user_id = user_id;
    }
}
