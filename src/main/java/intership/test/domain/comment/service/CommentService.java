package intership.test.domain.comment.service;

import intership.test.domain.board.entity.Board;
import intership.test.domain.board.exception.BoardNotFound;
import intership.test.domain.board.repository.BoardRepository;
import intership.test.domain.comment.dto.CommentCreate;
import intership.test.domain.comment.dto.CommentMapping;
import intership.test.domain.comment.dto.CommentUpdate;
import intership.test.domain.comment.entity.Comment;
import intership.test.domain.comment.exception.CommentNotFound;
import intership.test.domain.comment.repository.CommentRepository;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.UserNotFound;
import intership.test.domain.user.repository.UserRepository;
import intership.test.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    //C
    @Transactional
    public void createComment(CommentCreate commentCreate){
        User user = userRepository.findById(commentCreate.getUser_id()).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));
        Board board = boardRepository.findById(commentCreate.getBoard_idx()).orElseThrow(() -> new BoardNotFound(ErrorCode.BOARD_NOT_FOUND));

        Comment comment = CommentMapping.toComment(commentCreate, user, board);

        commentRepository.save(comment);
    }

    //R

    //U
    @Transactional
    public void updateComment(CommentUpdate commentUpdate, Long comment_id){
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() -> new CommentNotFound(ErrorCode.COMMENT_NOT_FOUND));
        User user = userRepository.findById(commentUpdate.getUser_id()).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));

        comment.updateComment(user, commentUpdate.getContent());

        commentRepository.save(comment);
    }
    //D
}
