package intership.test.domain.user.exception;

import intership.test.exception.CustomException;
import intership.test.exception.UserErrorCode;

public class UserAlreadExist extends CustomException {
    public UserAlreadExist(UserErrorCode userErrorCode) {
        super(userErrorCode);
    }
}
