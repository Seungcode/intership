package intership.test.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class UserCreate {
    @NotNull(message = "아이디를 입력하지 않았습니다.")
    private Long id;

    @NotBlank(message = "이름을 입력하지 않았습니다.")
    private String name;

    @NotNull(message = "나이를 입력하지 않았습니다.")
    private Integer age;

    public UserCreate(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
