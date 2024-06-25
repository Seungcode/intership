package intership.test.domain.user.controller;

import intership.test.domain.user.dto.UserCreate;
import intership.test.domain.user.dto.UserMapper;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.exception.InformationMissing;
import intership.test.domain.user.service.UserService;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    //C
    @PostMapping("/")
    public ResponseEntity<String> createUser(@Validated UserCreate userCreate, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMsg.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n");
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg.toString());
        }

        userService.createUser(userCreate);
        return ResponseEntity.ok("유저 생성을 완료하였습니다.");
    }

    //R
    @GetMapping("/{id}")
    public ResponseEntity<UserCreate> getOneUser(@RequestParam Long id){
        UserCreate user = userService.getOneUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserCreate>> getAllUser(){
        List<UserCreate> allUser = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(allUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @RequestParam Long id
    ){
        userService.deleteUser(id);
        return ResponseEntity.ok("유저 삭제를 완료하였습니다.");
    }
}
