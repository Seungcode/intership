package intership.test.domain.board.dto;

import intership.test.domain.comment.dto.CommentGet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardGetOne {
    private Long id;
    private String title;
    private String userName;
    private String content;
    private Timestamp create_at;
    private Integer like_num;
    private List<CommentGet> comment;

    @Builder
    public BoardGetOne(Long id, String title, String userName, String content, Timestamp create_at, Integer like_num, List<CommentGet> comment) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.content = content;
        this.create_at = create_at;
        this.like_num = like_num;
        this.comment = comment;
    }


}
