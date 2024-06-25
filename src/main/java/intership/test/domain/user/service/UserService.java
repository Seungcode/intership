package intership.test.domain.user.service;

import intership.test.domain.user.dto.UserCreate;
import intership.test.domain.user.dto.UserMapper;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.UserAlreadExist;
import intership.test.domain.user.exception.UserNotFound;
import intership.test.domain.user.repository.UserRepository;
import intership.test.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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

    //U

    //D
    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound(ErrorCode.USER_NOT_FOUND));

        userRepository.deleteById(id);

        log.info("삭제된 유저 : {}", user.getId());
    }
}
