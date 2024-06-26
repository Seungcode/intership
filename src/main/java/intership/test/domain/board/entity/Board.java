package intership.test.domain.board.entity;

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
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(name = "board_like", joinColumns = @JoinColumn(name = "board_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    List<User> users = new ArrayList<>();

    @Builder
    public Board(Long id, User user, String title, String content, int like_cnt, Timestamp createdAt, Timestamp modifiedAt, List<Comment> comments, List<User> users) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.like_cnt = like_cnt;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.comments = comments;
        this.users = users;
    }

    public void updateBoardLike(User user){
        this.users.add(user);
        this.like_cnt += 1;
    }

    public void updateBoardAfterDeleteUser(List<User> users){
        this.users = users;
        this.like_cnt = users.size();
    }

    public void updateBoard(User user, String title, String content){
        if(user!=null) this.user = user;
        if(title != null) this.title = title;
        if(content != null) this.content = content;
    }
}
