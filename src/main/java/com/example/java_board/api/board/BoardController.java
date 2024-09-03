package com.example.java_board.api.board;


import com.example.java_board.api.board.dto.CreateBoard;
import com.example.java_board.api.board.dto.CreateComment;
import com.example.java_board.api.board.dto.UpdateBoard;
import com.example.java_board.api.board.dto.UpdateComment;
import com.example.java_board.repository.board.Board;
import com.example.java_board._core.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createBoard(
            @RequestBody @Valid CreateBoard createBoard
    ) {
        boardService.create(createBoard);
        return ApiResponse.create();
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<ApiResponse<Void>> updateBoard(
            @PathVariable long boardId,
            @RequestBody @Valid UpdateBoard updateBoard
    ) {
        boardService.update(boardId, updateBoard);
        return ApiResponse.ok();
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<ApiResponse<Void>> deleteBoard(
            @PathVariable long boardId
    ) {
        boardService.delete(boardId);
        return ApiResponse.ok();
    }

    @PostMapping("/{boardId}/like")
    public ResponseEntity<ApiResponse<Void>> like(
            @PathVariable long boardId,
            @RequestParam long userId
    ) {
        boardService.like(boardId, userId);
        return ApiResponse.ok();
    }

    @PostMapping("/{boardId}/comment")
    public ResponseEntity<ApiResponse<Void>> createComment(
            @PathVariable long boardId,
            @RequestBody @Valid CreateComment createComment
    ) {
        commentService.create(boardId, createComment);
        return ApiResponse.create();
    }

    @PutMapping("/{boardId}/comment/{commentId}")
    public ResponseEntity<ApiResponse<Void>> updateComment(
            @PathVariable long boardId,
            @PathVariable long commentId,
            @RequestBody @Valid UpdateComment updateComment
    ) {
        commentService.update(boardId, commentId, updateComment);
        return ApiResponse.ok();
    }

    @DeleteMapping("/{boardId}/comment/{commentId}")
    public ResponseEntity<ApiResponse<Void>> deleteComment(
            @PathVariable long boardId,
            @PathVariable long commentId
    ) {
        commentService.delete(boardId, commentId);
        return ApiResponse.ok();
    }

    @PostMapping("/{boardId}/comment/{commentId}/like")
    public ResponseEntity<ApiResponse<Void>> commentLike(
            @PathVariable long boardId,
            @PathVariable long commentId,
            @RequestParam long userId
    ) {
        commentService.like(boardId, commentId, userId);
        ApiResponse.of(HttpStatus.NOT_FOUND, "");
        return ApiResponse.ok();
    }

}
