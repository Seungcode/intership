package intership.test.domain.like.entity;

import intership.test.domain.comment.entity.Comment;
import intership.test.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLike {
    @Id
    @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public CommentLike(Long id, User user, Comment comment) {
        this.id = id;
        this.user = user;
        this.comment = comment;
    }
}
