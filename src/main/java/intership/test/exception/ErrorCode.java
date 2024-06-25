package intership.test.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@Slf4j
public enum ErrorCode {
    //User
    USER_NOT_FOUND(BAD_REQUEST, "존재하지 않는 유저입니다, id를 다시 한 번 확인해주세요");

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
