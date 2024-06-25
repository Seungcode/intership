package intership.test.domain.user.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdate {
    @NotNull(message = "아이디를 입력하지 않았습니다.")
    private Long id;

    @Nullable
    private String name;

    @Nullable
    private Integer age;

    @Builder
    public UserUpdate(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
