CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      email VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL
);

CREATE TABLE board (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       content TEXT NOT NULL,
                       user_id BIGINT NOT NULL,
                       FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE comment (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         content TEXT NOT NULL,
                         user_id BIGINT NOT NULL,
                         board_id BIGINT NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                         FOREIGN KEY (board_id) REFERENCES board(id) ON DELETE CASCADE
);

CREATE TABLE board_like (
                            user_id BIGINT NOT NULL,
                            board_id BIGINT NOT NULL,
                            PRIMARY KEY (user_id, board_id),
                            FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                            FOREIGN KEY (board_id) REFERENCES board(id) ON DELETE CASCADE
);

CREATE TABLE comment_likes (
                            user_id BIGINT NOT NULL,
                            comment_id BIGINT NOT NULL,
                            PRIMARY KEY (user_id, comment_id),
                            FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                            FOREIGN KEY (comment_id) REFERENCES comment(id) ON DELETE CASCADE
);
