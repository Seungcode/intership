package com.example.java_board._test_utils.fixture;

import com.example.java_board.api.board.dto.CreateBoard;
import com.example.java_board.api.board.dto.UpdateBoard;
import com.example.java_board.repository.board.Board;
import com.example.java_board.repository.user.User;

public class BoardFixture {

    public static Board board(User user) {
        return new Board("title", "content", user);
    }

    public static Board board(String title, String content, User user) {
        return new Board(title, content, user);
    }

    public static CreateBoard createBoard() {
        return new CreateBoard(1L, "title", "content");
    }

    public static UpdateBoard updateBoard() {
        return new UpdateBoard(1L, "update title", "update content");
    }
}

