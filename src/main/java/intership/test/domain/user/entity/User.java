package intership.test.domain.user.entity;

import intership.test.domain.board.entity.Board;
import intership.test.domain.comment.entity.Comment;
import intership.test.domain.user.dto.UserCreate;
import intership.test.domain.user.dto.UserUpdate;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
public class User {
    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Timestamp modifiedAt;

    public User(UserCreate userCreate) {
        this.id = userCreate.getId();
        this.name = userCreate.getName();
        this.age = userCreate.getAge();
    }

    public void updateUser(UserUpdate userUpdate){
        this.name = userUpdate.getName();
        this.age = userUpdate.getAge();
    }

}
