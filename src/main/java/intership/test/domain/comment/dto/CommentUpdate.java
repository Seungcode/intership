package intership.test.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CommentUpdate {
    private Long user_id;
    private String content;

    public CommentUpdate(Long user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }
}
