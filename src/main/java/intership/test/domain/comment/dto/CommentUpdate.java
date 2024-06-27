package intership.test.domain.comment.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentUpdate {
    private Long user_id;
    private String content;

    public CommentUpdate(Long user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }
}
