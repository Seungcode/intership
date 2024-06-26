package intership.test.domain.board.dto;

import intership.test.domain.board.entity.Board;
import intership.test.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardMapper {
    public static Board toBoard(BoardCreate boardCreate, User user){
        return Board
                .builder()
                .user(user)
                .title(boardCreate.getTitle())
                .content(boardCreate.getContent())
                .build();
    }

    public static BoardGetAll toBoardGetAll(Board board){
        return BoardGetAll
                .builder()
                .id(board.getId())
                .title(board.getTitle())
                .userName(board.getUser().getName())
                .create_at(board.getCreatedAt())
                .build();
    }
}
