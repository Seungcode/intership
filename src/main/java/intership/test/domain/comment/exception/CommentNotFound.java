package intership.test.domain.comment.exception;

import intership.test.exception.CustomException;
import intership.test.exception.ErrorCode;

public class CommentNotFound extends CustomException {
    public CommentNotFound(ErrorCode errorCode) {
        super(errorCode);
    }
}
