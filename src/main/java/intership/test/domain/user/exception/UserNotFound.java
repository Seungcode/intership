package intership.test.domain.user.exception;


import intership.test.exception.CustomException;
import intership.test.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

public class UserNotFound extends CustomException {
    public UserNotFound(ErrorCode errorCode) {
        super(errorCode);
    }

}
