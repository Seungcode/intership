package intership.test.domain.like.service;

import intership.test.domain.comment.entity.Comment;
import intership.test.domain.comment.exception.CommentNotFound;
import intership.test.domain.comment.repository.CommentRepository;
import intership.test.domain.like.dto.CommentLikeMapper;
import intership.test.domain.like.entity.CommentLike;
import intership.test.domain.like.entity.LikeId;
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
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void pressLike(LikeId likeId){
        Comment comment = commentRepository.findById(likeId.getComment().getId()).orElseThrow(() -> new CommentNotFound(ErrorCode.COMMENT_NOT_FOUND));
        CommentLike commentLike = CommentLikeMapper.toCommentLike(likeId);
        Comment result = commentLike.pressLike(comment, commentLike);
        commentRepository.save(result);
    }
}
