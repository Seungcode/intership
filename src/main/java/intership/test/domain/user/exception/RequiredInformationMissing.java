package intership.test.domain.user.exception;

import intership.test.exception.CustomException;
import intership.test.exception.ErrorCode;

public class RequiredInformationMissing extends CustomException {
    public RequiredInformationMissing(ErrorCode errorCode){
        super(errorCode);
    }
}
