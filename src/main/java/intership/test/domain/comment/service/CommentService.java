package intership.test.domain.comment.service;

import intership.test.domain.board.entity.Board;
import intership.test.domain.board.exception.BoardNotFound;
import intership.test.domain.board.repository.BoardRepository;
import intership.test.domain.comment.dto.CommentCreate;
import intership.test.domain.comment.dto.CommentGet;
import intership.test.domain.comment.dto.CommentMapping;
import intership.test.domain.comment.dto.CommentUpdate;
import intership.test.domain.comment.entity.Comment;
import intership.test.domain.comment.exception.CommentNotFound;
import intership.test.domain.comment.repository.CommentRepository;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.UserNotFound;
import intership.test.domain.user.repository.UserRepository;
import intership.test.exception.BoardErrorCode;
import intership.test.exception.CommentErrorCode;
import intership.test.exception.UserErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        User user = userRepository.findById(commentCreate.getUser_id()).orElseThrow(() -> new UserNotFound(UserErrorCode.USER_NOT_FOUND));
        Board board = boardRepository.findById(commentCreate.getBoard_idx()).orElseThrow(() -> new BoardNotFound(BoardErrorCode.BOARD_NOT_FOUND));

        Comment comment = CommentMapping.toComment(commentCreate, user, board);

        commentRepository.save(comment);
    }

    //R
    @Transactional
    public CommentGet getOneComment(Long comment_id){
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() -> new CommentNotFound(CommentErrorCode.COMMENT_NOT_FOUND));
        User user = userRepository.findById(comment.getUser().getId()).orElseThrow(() -> new UserNotFound(UserErrorCode.USER_NOT_FOUND));

        return CommentMapping.toCommentGet(comment, user);
    }

    //U
    @Transactional
    public void updateComment(CommentUpdate commentUpdate, Long comment_id){
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() -> new CommentNotFound(CommentErrorCode.COMMENT_NOT_FOUND));
        User user = userRepository.findById(commentUpdate.getUser_id()).orElseThrow(() -> new UserNotFound(UserErrorCode.USER_NOT_FOUND));

        comment.updateComment(user, commentUpdate);

        commentRepository.save(comment);
    }

    //D
    @Transactional
    public void deleteComment(Long comment_id){
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() -> new CommentNotFound(CommentErrorCode.COMMENT_NOT_FOUND));

        log.info("삭제할 댓글 정보 : id = {}, content = {}", comment.getId(), comment.getContent());

        commentRepository.deleteById(comment_id);
    }
}
