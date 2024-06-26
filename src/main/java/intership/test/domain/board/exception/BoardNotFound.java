package intership.test.domain.board.exception;

import intership.test.exception.CustomException;
import intership.test.exception.ErrorCode;

public class BoardNotFound extends CustomException {
    public BoardNotFound (ErrorCode errorCode){
        super(errorCode);
    }
}
