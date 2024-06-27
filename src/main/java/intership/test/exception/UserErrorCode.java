package intership.test.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@Slf4j
public enum UserErrorCode implements ErrorCode{
    //User
    USER_NOT_FOUND(404, "존재하지 않는 유저입니다, id를 다시 한 번 확인해주세요"),
    USER_ALREADY_EXIST(400, "이미 사용중인 아이디 입니다, 다른 아이디로 시도해주세요"),
    REQUIRED_INFORMATION_MISSING(400, "필수 입력값이 입력되지 않았습니다. 공백이 없도록 입력해주세요"),
    ID_CHANGE_NOT_ALLOWED(400, "아이디를 변경할 수 없습니다. 다시 한 번 확인해주세요.");

    private final int statusCode;
    private final String message;

    UserErrorCode(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
