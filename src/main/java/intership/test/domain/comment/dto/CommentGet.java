package intership.test.domain.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class CommentGet {
    private String content;
    private String userName;
    private Timestamp create_at;

    @Builder
    public CommentGet(String content, String userName, Timestamp create_at) {
        this.content = content;
        this.userName = userName;
        this.create_at = create_at;
    }
}
