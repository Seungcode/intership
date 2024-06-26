package intership.test.domain.user.service;

import intership.test.domain.board.service.BoardLikeService;
import intership.test.domain.user.dto.UserCreate;
import intership.test.domain.user.dto.UserMapper;
import intership.test.domain.user.dto.UserUpdate;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.IdChangeNotAllowed;
import intership.test.domain.user.exception.UserAlreadExist;
import intership.test.domain.user.exception.UserNotFound;
import intership.test.domain.user.repository.UserRepository;
import intership.test.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BoardLikeService boardLikeService;

    //C
    @Transactional
    public void createUser(UserCreate userCreate){
        Optional<User> exist = userRepository.findById(userCreate.getId());

        if(!exist.isEmpty()){
            throw new UserAlreadExist(ErrorCode.USER_ALREADY_EXIST);
        }

        userRepository.save(UserMapper.toUser(userCreate));

        log.info("생성된 유저 : {}", userCreate.getId());
    }

    //R
    @Transactional
    public UserCreate getOneUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));

        return UserMapper.toUserCreate(user);
    }

    @Transactional
    public List<UserCreate> getAllUser(){
        List<UserCreate> result = new ArrayList<>();

        for (User user : userRepository.findAll()) {
            log.info("user id: {}", user.getId());
            result.add(UserMapper.toUserCreate(user));
        }

        return result;
    }

    //U
    @Transactional
    public void updateUser(Long id, UserUpdate userUpdate){
        if(id!=userUpdate.getId()) throw new IdChangeNotAllowed(ErrorCode.ID_CHANGE_NOT_ALLOWED);
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));

        user.updateUser(userUpdate.getName(), userUpdate.getAge());
        userRepository.save(user);

        log.info("수정된 정보 : id={}, name={}, age={}", userUpdate.getId(), userUpdate.getName(), userUpdate.getAge());
    }

    //D
    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));

        boardLikeService.deleteBoardLike(id);

        log.info("삭제된 유저 : {}", user.getId());

        userRepository.deleteById(id);

    }
}
