package intership.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 특정 예외를 처리하는 메서드
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleUserNotFoundException(CustomException ex) {
        return ResponseEntity.status(ex.getErrorCode().getStatusCode())
                .body(ex.getErrorCode().getMessage());
    }

    // 다른 예외를 처리하는 메서드
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
