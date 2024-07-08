package group40.whatrentshopapp.dto.userDto;

import group40.whatrentshopapp.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

    public UserRequestDto(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
