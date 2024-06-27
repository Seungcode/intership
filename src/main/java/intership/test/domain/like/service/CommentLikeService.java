package intership.test.domain.like.service;

import intership.test.domain.comment.entity.Comment;
import intership.test.domain.comment.exception.CommentNotFound;
import intership.test.domain.comment.repository.CommentRepository;
import intership.test.domain.like.dto.CommentLikeCreate;
import intership.test.domain.like.dto.CommentLikeMapper;
import intership.test.domain.like.entity.CommentLike;
import intership.test.domain.like.entity.LikeId;
import intership.test.domain.user.dto.UserCreate;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.UserNotFound;
import intership.test.domain.user.repository.UserRepository;
import intership.test.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentLikeService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Transactional
    public void pressLike(CommentLikeCreate commentLikeCreate){
        User user = userRepository.findById(commentLikeCreate.getUser_id()).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));
        Comment comment = commentRepository.findById(commentLikeCreate.getComment_id()).orElseThrow(() -> new CommentNotFound(ErrorCode.COMMENT_NOT_FOUND));
        CommentLike commentLike = CommentLikeMapper.toCommentLike(user, comment);
        Comment result = commentLike.pressLike(comment, commentLike);
        commentRepository.save(result);
    }
}
