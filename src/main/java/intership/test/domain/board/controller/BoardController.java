package intership.test.domain.board.controller;

import intership.test.domain.board.dto.BoardCreate;
import intership.test.domain.board.dto.BoardGetAll;
import intership.test.domain.board.dto.BoardGetOne;
import intership.test.domain.board.service.BoardService;
import intership.test.domain.user.dto.UserCreate;
import intership.test.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Board API", description = "게시판 관련 API")
public class BoardController {
    private final BoardService boardService;

    //C
    @PostMapping("")
    @Operation(summary = "게시물 생성 API", description = "새로운 게시물을 생성하는 API입니다.")
    public ResponseEntity<String> createBoard(
            @Validated BoardCreate boardCreate,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMsg.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n");
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg.toString());
        }

        boardService.createBoard(boardCreate);
        return ResponseEntity.ok("게시물 생성을 완료하였습니다.");
    }

    //R
    @GetMapping("")
    @Operation(summary = "전체 게시물 받아오기 API", description = "전체 게시물을 받아오는 API입니다. (idx/제목/작성자/생성일자)")
    public ResponseEntity<List<BoardGetAll>> getAllBoard(){
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getAllBoard());
    }

    @GetMapping("/{board_idx}")
    @Operation(summary = "단일 게시물 받아오기 API", description = "단일 게시물을 받아오는 API입니다.")
    public ResponseEntity<BoardGetOne> getOneBoard(@PathVariable Long board_idx){
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getOneBoard(board_idx));
    }

}
