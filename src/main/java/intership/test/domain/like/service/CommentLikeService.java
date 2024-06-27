package intership.test.domain.like.service;

import intership.test.domain.board.entity.Board;
import intership.test.domain.board.exception.BoardNotFound;
import intership.test.domain.board.repository.BoardRepository;
import intership.test.domain.comment.entity.Comment;
import intership.test.domain.comment.exception.CommentNotFound;
import intership.test.domain.comment.repository.CommentRepository;
import intership.test.domain.like.dto.CommentLikeCreate;
import intership.test.domain.like.dto.CommentLikeMapper;
import intership.test.domain.like.entity.CommentLike;
import intership.test.domain.like.repository.CommentLikeRepository;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.UserNotFound;
import intership.test.domain.user.repository.UserRepository;
import intership.test.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentLikeService {
    private final CommentLikeRepository commentLikeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public boolean pressLike(CommentLikeCreate commentLikeCreate){
        Optional<CommentLike> commentExist = commentLikeRepository.findByUserIdAndCommentId(commentLikeCreate.getUser_id(), commentLikeCreate.getComment_id());
        if(!commentExist.isEmpty()){
            commentLikeRepository.deleteById(commentExist.get().getId());
            return false;
        }
        else{
            User user = userRepository.findById(commentLikeCreate.getUser_id()).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));
            Comment comment = commentRepository.findById(commentLikeCreate.getComment_id()).orElseThrow(() -> new CommentNotFound(ErrorCode.COMMENT_NOT_FOUND));
            commentLikeRepository.save(CommentLikeMapper.toCommentLike(user, comment));
        }
        return true;
    }
}
