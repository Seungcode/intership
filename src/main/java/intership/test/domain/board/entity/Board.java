package intership.test.domain.board.entity;

import intership.test.domain.comment.entity.Comment;
import intership.test.domain.like.entity.Likes;
import intership.test.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Timestamp modifiedAt;


    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    @OrderBy("id asc")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(name = "board_like", joinColumns = @JoinColumn(name = "board_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    List<User> users = new ArrayList<>();

    @Builder
    public Board(Long id, User user, String title, String content, Timestamp createdAt, Timestamp modifiedAt, List<Comment> comments, List<User> users) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.comments = comments;
        this.users = users;
    }

    public void updateBoardLike(User user){
        this.users.add(user);
    }
}
