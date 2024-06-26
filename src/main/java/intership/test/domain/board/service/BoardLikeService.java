package intership.test.domain.board.service;

import intership.test.domain.board.entity.Board;
import intership.test.domain.board.exception.BoardNotFound;
import intership.test.domain.board.repository.BoardRepository;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.UserNotFound;
import intership.test.domain.user.repository.UserRepository;
import intership.test.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardLikeService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void createBoardLike(Long id, Long board_idx){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));
        Board board = boardRepository.findById(board_idx).orElseThrow(() -> new BoardNotFound(ErrorCode.BOARD_NOT_FOUND));

        board.updateBoardLike(user);

        log.info("게시물 관련 정보입니다. 게시물 id : {} 좋아요 수 : {}", board.getId(), board.getUsers().size());
    }

    @Transactional
    public void deleteBoardLike(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));

        List<Board> boards = user.getBoard_like();
        for (Board board : boards) {
            List<User> users = board.getUsers();
            users.remove(user);
            board.updateBoardAfterDeleteUser(users);
        }
    }

}
