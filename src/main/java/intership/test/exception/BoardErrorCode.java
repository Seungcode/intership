package intership.test.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
@Getter
@Slf4j
public enum BoardErrorCode implements ErrorCode{
    //Board
    BOARD_NOT_FOUND(404, "존재하지 않는 게시물입니다, idx를 다시 한 번 확인해주세요");

    private final int statusCode;
    private final String message;

    BoardErrorCode(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

}
