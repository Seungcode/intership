package intership.test.domain.comment.dto;

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
    private Integer like_cnt;
    private Timestamp create_at;

    @Builder
    public CommentGet(String content, String userName, Integer like_cnt, Timestamp create_at) {
        this.content = content;
        this.userName = userName;
        this.like_cnt = like_cnt;
        this.create_at = create_at;
    }
}
