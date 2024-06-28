package intership.test.domain.board.dto;

import intership.test.domain.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class BoardGetAll {
    private Long id;
    private String title;
    private String userName;
    private Timestamp create_at;

    public BoardGetAll(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.userName = board.getUser().getName();
        this.create_at = board.getCreatedAt();
    }
}
