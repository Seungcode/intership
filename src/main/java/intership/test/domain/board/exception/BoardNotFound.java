package intership.test.domain.board.exception;

import intership.test.exception.BoardErrorCode;
import intership.test.exception.CustomException;
import intership.test.exception.UserErrorCode;

public class BoardNotFound extends CustomException {
    public BoardNotFound (BoardErrorCode boardErrorCode){
        super(boardErrorCode);
    }
}
