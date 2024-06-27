package intership.test.domain.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class BoardGetAll {
    private Long id;
    private String title;
    private String userName;
    private Timestamp create_at;

    @Builder
    public BoardGetAll(Long id, String title, String userName, Timestamp create_at) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.create_at = create_at;
    }
}
