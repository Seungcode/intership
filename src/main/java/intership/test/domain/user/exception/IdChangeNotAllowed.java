package intership.test.domain.user.exception;

import intership.test.exception.CustomException;
import intership.test.exception.ErrorCode;

public class IdChangeNotAllowed extends CustomException {
    public IdChangeNotAllowed(ErrorCode errorCode) {
        super(errorCode);
    }
}
