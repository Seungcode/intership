package intership.test.domain.user.exception;

import intership.test.exception.CustomException;
import intership.test.exception.UserErrorCode;

public class RequiredInformationMissing extends CustomException {
    public RequiredInformationMissing(UserErrorCode userErrorCode){
        super(userErrorCode);
    }
}
