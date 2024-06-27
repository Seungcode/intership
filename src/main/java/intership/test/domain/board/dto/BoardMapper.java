package intership.test.domain.board.dto;

import intership.test.domain.board.entity.Board;
import intership.test.domain.comment.dto.CommentGet;
import intership.test.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardMapper {
    public static Board toBoard(BoardCreate boardCreate, User user){
        return new Board(boardCreate, user);
    }

    public static Board toBoard(BoardUpdate boardUpdate, User user){
        return new Board(boardUpdate, user);
    }

    public static BoardGetAll toBoardGetAll(Board board){
        return new BoardGetAll(board.getId(), board.getTitle(), board.getUser().getName(), board.getCreatedAt());
    }

    public static BoardGetOne toBoardGetOne(Board board, List<CommentGet> commentGets){
        return new BoardGetOne(board.getId(), board.getTitle(), board.getUser().getName(), board.getContent(), board.getCreatedAt(), board.getUsers().size(), commentGets);
    }

}
