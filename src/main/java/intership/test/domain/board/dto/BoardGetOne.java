package intership.test.domain.board.dto;

import intership.test.domain.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class BoardGetOne {
    private Long id;
    private String title;
    private String userName;
    private String content;
    private Timestamp create_at;
    private Integer like_num;

    public BoardGetOne(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.userName = board.getUser().getName();
        this.content = board.getContent();
        this.create_at = board.getCreatedAt();
        this.like_num = board.getLike_cnt();
    }


}
