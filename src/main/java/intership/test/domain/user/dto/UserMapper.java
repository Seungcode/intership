package intership.test.domain.user.dto;

import intership.test.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMapper {
    public static User toUser(UserCreate userCreate){
        return new User(userCreate);
    }

    public static UserCreate toUserCreate(User user){
        return new UserCreate(user.getId(), user.getName(), user.getAge());
    }
}
