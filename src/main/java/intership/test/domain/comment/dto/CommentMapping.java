package intership.test.domain.comment.dto;

import intership.test.domain.board.entity.Board;
import intership.test.domain.comment.entity.Comment;
import intership.test.domain.user.entity.User;

public class CommentMapping {
    public static Comment toComment(CommentCreate commentCreate, User user, Board board){
        return new Comment(commentCreate, user, board);
    }

    public static Comment toComment(CommentUpdate commentUpdate, User user){
        return new Comment(commentUpdate);
    }

    public static CommentGet toCommentGet(Comment comment, User user){
        return new CommentGet(comment.getContent(), user.getName(), comment.getCommentLikes().size(), comment.getCreatedAt());
    }
}
