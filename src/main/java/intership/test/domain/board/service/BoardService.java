package intership.test.domain.board.service;

import intership.test.domain.board.dto.*;
import intership.test.domain.board.entity.Board;
import intership.test.domain.board.exception.BoardNotFound;
import intership.test.domain.board.repository.BoardRepository;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.UserNotFound;
import intership.test.domain.user.repository.UserRepository;
import intership.test.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    //C
    @Transactional
    public void createBoard(BoardCreate boardCreate){
        User user = userRepository.findById(boardCreate.getUser_id()).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));
        Board board = BoardMapper.toBoard(boardCreate, user);
        boardRepository.save(board);

        log.info("생성된 게시물 관련 정보입니다. 게시물 id : {} 작성자 : {}, 제목 : {}", board.getId(), user.getName(), board.getTitle());
    }

    //R
    @Transactional
    public List<BoardGetAll> getAllBoard(){
        List<BoardGetAll> result = new ArrayList<>();
        for (Board board : boardRepository.findAll()) {
            result.add(BoardMapper.toBoardGetAll(board));
        }
        return result;
    }

    @Transactional
    public BoardGetOne getOneBoard(Long idx){
        Board board = boardRepository.findById(idx).orElseThrow(() -> new BoardNotFound(ErrorCode.BOARD_NOT_FOUND));
        return BoardMapper.toBoardGetOne(board);
    }

    //U
    @Transactional
    public void updateBoard(BoardUpdate boardUpdate, Long idx){
        User user = userRepository.findById(boardUpdate.getUser_id()).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));
        Board board = boardRepository.findById(idx).orElseThrow(() -> new BoardNotFound(ErrorCode.BOARD_NOT_FOUND));

        board.updateBoard(user, boardUpdate.getTitle(), boardUpdate.getContent());
        boardRepository.save(board);
    }

    //D
    @Transactional
    public void deleteBoard(Long idx){
        Board board = boardRepository.findById(idx).orElseThrow(() -> new BoardNotFound(ErrorCode.BOARD_NOT_FOUND));

        log.info("삭제된 게시물 : {}",board.getId());

        boardRepository.deleteById(idx);
    }


}
