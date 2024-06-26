package intership.test.domain.user.entity;

import intership.test.domain.board.entity.Board;
import intership.test.domain.comment.entity.Comment;
import intership.test.domain.like.entity.Likes;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Timestamp.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;

    private Integer age;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Timestamp modifiedAt;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    List<Board> boards_like = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Likes> likes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Board> boards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    public User(Long id, String name, Integer age, Timestamp createdAt, Timestamp modifiedAt, List<Board> boards_like, List<Likes> likes, List<Board> boards, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.boards_like = boards_like;
        this.likes = likes;
        this.boards = boards;
        this.comments = comments;
    }

    @Builder
    public User(Long id, String name, Integer age, Timestamp createdAt, Timestamp modifiedAt, List<Likes> likes, List<Board> boards, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.likes = likes;
        this.boards = boards;
        this.comments = comments;
    }

    public void updateUser(String name, Integer age){
        if (name != null) {
            this.name = name;
        }
        if (age != null) {
            this.age = age;
        }
    }
}
