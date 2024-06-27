package intership.test.exception;

import lombok.Getter;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum CommentErrorCode implements ErrorCode{
    //Comment
    COMMENT_NOT_FOUND(404, "존재하지 않는 댓글입니다, idx를 다시 한 번 확인해주세요");
    private final int statusCode;
    private final String message;

    CommentErrorCode(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
