package intership.test.domain.board.entity;

import intership.test.domain.board.dto.BoardCreate;
import intership.test.domain.board.dto.BoardUpdate;
import intership.test.domain.comment.entity.Comment;
import intership.test.domain.user.entity.User;
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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private Integer like_cnt = 0;
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Timestamp modifiedAt;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    @OrderBy("id asc")
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "board_like", joinColumns = @JoinColumn(name = "board_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> users = new ArrayList<>();

    public Board(BoardCreate boardCreate, User user) {
        this.user = user;
        this.title = boardCreate.getTitle();
        this.content = boardCreate.getContent();
    }

    public Board(BoardUpdate boardUpdate, User user) {
        this.user = user;
        this.title = boardUpdate.getTitle();
        this.content = boardUpdate.getContent();
    }

    public void updateBoardLike(User user){
        this.users.add(user);
        this.like_cnt += 1;
    }

    public void updateBoardAfterDeleteUser(List<User> users){
        this.users = users;
        this.like_cnt = users.size();
    }

    public void updateBoard(BoardUpdate boardUpdate, User user){
        this.user = user;
        this.title = boardUpdate.getTitle();
        this.content = boardUpdate.getContent();
    }

    public void writerDelete(User user){
        this.user = user;
    }
}
