package intership.test.domain.comment.controller;

import intership.test.domain.board.dto.BoardCreate;
import intership.test.domain.comment.dto.CommentCreate;
import intership.test.domain.comment.dto.CommentMapping;
import intership.test.domain.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Comment API", description = "댓글 관련 API")
public class CommentController {

    private final CommentService commentService;

    //C
    @PostMapping("")
    @Operation(summary = "댓글 생성 API", description = "새로운 댓글을 생성하는 API입니다.")
    public ResponseEntity<String> createComment(
            @Validated CommentCreate commentCreate,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMsg.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n");
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg.toString());
        }

        commentService.createComment(commentCreate);
        return ResponseEntity.ok("댓글 생성을 완료하였습니다.");
    }
}
