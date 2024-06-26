package intership.test.domain.comment.dto;

import intership.test.domain.board.entity.Board;
import intership.test.domain.comment.entity.Comment;
import intership.test.domain.user.entity.User;

public class CommentMapping {
    public static Comment toComment(CommentCreate commentCreate, User user, Board board){
        return Comment
                .builder()
                .content(commentCreate.getContent())
                .user(user)
                .board(board)
                .build();
    }

    public static CommentGet toCommentGet(Comment comment, User user){
        return CommentGet
                .builder()
                .content(comment.getContent())
                .userName(user.getName())
                .create_at(comment.getCreatedAt())
                .build();
    }
}
