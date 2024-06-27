package intership.test.domain.like.controller;

import intership.test.domain.like.dto.CommentLikeCreate;
import intership.test.domain.like.entity.LikeId;
import intership.test.domain.like.service.CommentLikeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/board/comment")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Like API", description = "좋아요 관련 API")
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @PostMapping("/{comment_idx}/like")
    public ResponseEntity<String> createCommentLike(
            @PathVariable("comment_idx") Long comment_idx,
            @RequestBody Long user_id
            ){
        commentLikeService.pressLike(new CommentLikeCreate(user_id, comment_idx));
        return ResponseEntity.ok("좋아요 처리를 성공적으로 진행했습니다.");
    }
}
