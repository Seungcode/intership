package intership.test.domain.comment.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentGet {
    private String content;
    private String userName;
    private Integer like_cnt;
    private Timestamp create_at;

    public CommentGet(String content, String userName, Integer like_cnt, Timestamp create_at) {
        this.content = content;
        this.userName = userName;
        this.like_cnt = like_cnt;
        this.create_at = create_at;
    }
}
