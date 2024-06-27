package intership.test.domain.user.controller;

import intership.test.domain.user.dto.UserCreate;
import intership.test.domain.user.dto.UserUpdate;
import intership.test.domain.user.entity.User;
import intership.test.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "User API", description = "유저 관련 API")
public class UserController {

    private final UserService userService;

    //C
    @PostMapping("")
    @Operation(summary = "User 생성 API", description = "새로운 유저를 생성하는 API입니다.")
    public ResponseEntity<String> createUser(
            @Validated UserCreate userCreate,
            BindingResult bindingResult
    ){
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
    @GetMapping("/{user_id}")
    @Operation(summary = "단일 User 불러오기 API", description = "특정 유저의 정보를 불러오는 API입니다.")
    public ResponseEntity<UserCreate> getOneUser(
            @PathVariable Long user_id
    ){
        UserCreate user = userService.getOneUser(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("")
    @Operation(summary = "전체 User 불러오기 API", description = "전체 유저의 정보를 불러오는 API입니다.")
    public ResponseEntity<List<UserCreate>> getAllUser(){
        List<UserCreate> allUser = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(allUser);
    }

    //U
    @PatchMapping("/{user_id}")
    @Operation(summary = "User 변경 API", description = "기존 유저의 이름 / 나이를 변경할 수 있는 API입니다.")
    public ResponseEntity<String> updateUser(
            @PathVariable Long user_id,
            @RequestBody UserUpdate userUpdate
            ){
        userService.updateUser(user_id, userUpdate);
        return ResponseEntity.ok("유저 정보 변경을 완료하였습니다.");
    }

    //D
    @DeleteMapping("/{user_id}")
    @Operation(summary = "User 삭제 API", description = "유저를 DB에서 삭제하는 API입니다.")
    public ResponseEntity<String> deleteUser(
            @PathVariable Long user_id
    ){
        userService.deleteUser(user_id);
        return ResponseEntity.ok("유저 삭제를 완료하였습니다.");
    }
}
