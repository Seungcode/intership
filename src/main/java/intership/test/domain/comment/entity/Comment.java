package intership.test.domain.comment.entity;

import intership.test.domain.board.entity.Board;
import intership.test.domain.comment.dto.CommentCreate;
import intership.test.domain.comment.dto.CommentUpdate;
import intership.test.domain.like.entity.CommentLike;
import intership.test.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Timestamp modifiedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "like_id.comment")
    private List<CommentLike> commentLikes = new ArrayList<>();

    public Comment(CommentCreate commentCreate, User user, Board board) {
        this.content = commentCreate.getContent();
        this.user = user;
        this.board = board;
    }

    public Comment(CommentUpdate commentUpdate) {
        this.content = commentUpdate.getContent();
    }

    public void updateComment(User user, CommentUpdate commentUpdate){
        this.user = user;
        this.content = commentUpdate.getContent();
    }

    public void updateCommentLike(List<CommentLike> commentLikes){
        this.commentLikes = commentLikes;
    }

    public void writerDelete(User user){
        this.user = user;
    }
}
