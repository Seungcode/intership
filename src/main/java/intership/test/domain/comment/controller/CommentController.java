package intership.test.domain.comment.controller;

import intership.test.domain.comment.dto.CommentCreate;
import intership.test.domain.comment.dto.CommentGet;
import intership.test.domain.comment.dto.CommentUpdate;
import intership.test.domain.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    //R
    @GetMapping("/{comment_idx}")
    @Operation(summary = "댓글 읽어오기 API", description = "단일 댓글을 읽어오는 API입니다.")
    public ResponseEntity<CommentGet> getOneComment(@PathVariable Long comment_idx){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getOneComment(comment_idx));
    }

    //U
    @PatchMapping("/{comment_idx}")
    @Operation(summary = "댓글 수정 API", description = "댓글을 수정하는 API입니다.")
    public ResponseEntity<String> updateComment(@PathVariable Long comment_idx,
                                                @RequestBody CommentUpdate commentUpdate){
        commentService.updateComment(commentUpdate, comment_idx);

        return ResponseEntity.ok("댓글 수정을 완료하였습니다.");
    }

    //D
    @DeleteMapping("/{comment_idx}")
    @Operation(summary = "댓글 삭제 API", description = "댓글을 삭제하는 API입니다.")
    public ResponseEntity<String> deleteComment(@PathVariable Long comment_idx){
        commentService.deleteComment(comment_idx);

        return ResponseEntity.ok("댓글 삭제를 완료하였습니다.");
    }

}
