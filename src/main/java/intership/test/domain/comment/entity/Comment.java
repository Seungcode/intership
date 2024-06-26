package intership.test.domain.comment.entity;

import intership.test.domain.board.entity.Board;
import intership.test.domain.comment.dto.CommentUpdate;
import intership.test.domain.like.entity.CommentLike;
import intership.test.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
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

    @OneToMany(mappedBy = "comment")
    private List<CommentLike> commentLikes;

    @Builder
    public Comment(Long id, String content, Timestamp createdAt, Timestamp modifiedAt, User user, Board board, List<CommentLike> commentLikes) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.user = user;
        this.board = board;
        this.commentLikes = commentLikes;
    }

    public void updateComment(User user, String content){
        if(user != null) this.user = user;
        if(content != null) this.content = content;
    }
}
