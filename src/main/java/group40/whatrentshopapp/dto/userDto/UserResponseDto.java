package group40.whatrentshopapp.dto.userDto;

import group40.whatrentshopapp.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Integer id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
