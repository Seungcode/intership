package intership.test.domain.user.dto;

import intership.test.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMapper {
    public static User toUser(UserCreate userCreate){
        return User
                .builder()
                .id(userCreate.getId())
                .name(userCreate.getName())
                .age(userCreate.getAge())
                .build();
    }

    public static UserCreate toUserCreate(User user){
        return UserCreate
                .builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }
}
