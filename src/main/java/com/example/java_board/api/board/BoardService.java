package com.example.java_board.api.board;

import com.example.java_board.api.board.dto.CreateBoard;
import com.example.java_board.api.board.dto.UpdateBoard;
import com.example.java_board.api.board.exception.NotFoundBoardException;
import com.example.java_board.api.board.mapper.BoardMapper;
import com.example.java_board.api.user.exception.NotFoundUserException;
import com.example.java_board.repository.board.Board;
import com.example.java_board.repository.board.BoardRepository;
import com.example.java_board.repository.user.User;
import com.example.java_board.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Transactional
    public void create(CreateBoard createBoard) {
        Board board = boardMapper.toEntity(createBoard);
        boardRepository.save(board);
    }

    @Transactional
    public void update(long id, UpdateBoard updateBoard) {
        Board board = boardRepository.findById(id).orElseThrow(NotFoundBoardException::new);
        board.update(updateBoard);
        boardRepository.save(board);
    }

    @Transactional
    public void delete(long id) {
        if (!boardRepository.existsById(id)) {
            throw new NotFoundBoardException();
        }

        boardRepository.deleteById(id);
    }

    @Transactional
    public void like(long id, long userId) {
        Board board = boardRepository.findById(id).orElseThrow(NotFoundBoardException::new);
        User user = userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
        board.like(user);
        boardRepository.save(board);
    }

}