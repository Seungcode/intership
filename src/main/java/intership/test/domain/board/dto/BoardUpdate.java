package intership.test.domain.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BoardUpdate {
    private Long user_id;
    private String content;
    private String title;

    @Builder
    public BoardUpdate(Long user_id, String content, String title) {
        this.user_id = user_id;
        this.content = content;
        this.title = title;
    }
}
