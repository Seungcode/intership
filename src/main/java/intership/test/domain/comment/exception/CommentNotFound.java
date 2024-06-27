package intership.test.domain.comment.exception;

import intership.test.exception.CommentErrorCode;
import intership.test.exception.CustomException;
import intership.test.exception.UserErrorCode;

public class CommentNotFound extends CustomException {
    public CommentNotFound(CommentErrorCode commentErrorCode) {
        super(commentErrorCode);
    }
}
