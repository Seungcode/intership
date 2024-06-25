package intership.test.domain.user.exception;

import intership.test.exception.CustomException;
import intership.test.exception.ErrorCode;

public class InformationMissing extends CustomException {
    public InformationMissing(ErrorCode errorCode){
        super(errorCode);
    }
}
