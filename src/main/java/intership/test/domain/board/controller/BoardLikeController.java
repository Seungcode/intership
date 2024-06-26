package intership.test.domain.board.controller;

import intership.test.domain.board.service.BoardLikeService;
import intership.test.domain.board.service.BoardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/like")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Like API", description = "좋아요 관련 API")
public class BoardLikeController {
    private final BoardLikeService boardLikeService;

    @PostMapping("/board")
    public ResponseEntity<String> createBoardLike(
            @RequestParam Long id,
            @RequestParam Long board_idx
    ){
        boardLikeService.createBoardLike(id, board_idx);
        return ResponseEntity.ok("좋아요 처리를 성공적으로 진행했습니다.");
    }
}
