package intership.test.domain.like.controller;

import intership.test.domain.like.entity.LikeId;
import intership.test.domain.like.service.CommentLikeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/like")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Like API", description = "좋아요 관련 API")
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @PostMapping("/comment")
    public ResponseEntity<String> createCommentLike(
            @RequestBody LikeId likeId
            ){
        commentLikeService.pressLike(likeId);
        return ResponseEntity.ok("좋아요 처리를 성공적으로 진행했습니다.");
    }
}
