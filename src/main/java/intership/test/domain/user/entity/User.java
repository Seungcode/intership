package intership.test.domain.user.entity;

import intership.test.domain.board.entity.Board;
import intership.test.domain.comment.entity.Comment;
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
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;

    private Integer age;

    @ManyToMany(mappedBy = "users")
    private List<Board> board_like;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Timestamp modifiedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Board> boards;

    //ON DELETE SET DEFAULT
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @Builder
    public User(Long id, String name, Integer age, Timestamp createdAt, Timestamp modifiedAt, List<Board> boards, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
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
