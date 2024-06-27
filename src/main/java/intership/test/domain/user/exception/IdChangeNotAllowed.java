package intership.test.domain.user.exception;

import intership.test.exception.CustomException;
import intership.test.exception.UserErrorCode;

public class IdChangeNotAllowed extends CustomException {
    public IdChangeNotAllowed(UserErrorCode userErrorCode) {
        super(userErrorCode);
    }
}
