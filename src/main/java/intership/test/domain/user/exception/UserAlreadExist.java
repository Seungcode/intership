package intership.test.domain.user.exception;

import intership.test.exception.CustomException;
import intership.test.exception.ErrorCode;

public class UserAlreadExist extends CustomException {
    public UserAlreadExist(ErrorCode errorCode) {
        super(errorCode);
    }
}
