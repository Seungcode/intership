package intership.test.domain.user.exception;


import intership.test.exception.CustomException;
import intership.test.exception.UserErrorCode;

public class UserNotFound extends CustomException {
    public UserNotFound(UserErrorCode userErrorCode) {
        super(userErrorCode);
    }

}
