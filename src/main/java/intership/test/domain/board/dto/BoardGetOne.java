package intership.test.domain.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class BoardGetOne {
    private Long id;
    private String title;
    private String userName;
    private String content;
    private Timestamp create_at;

    @Builder
    public BoardGetOne(Long id, String title, String userName, String content, Timestamp create_at) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.content = content;
        this.create_at = create_at;
    }
}
