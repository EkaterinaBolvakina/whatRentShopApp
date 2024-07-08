package group40.whatrentshopapp.service.interfaces.userServiceInterface;

import group40.whatrentshopapp.dto.userDto.UserResponseDto;
import org.springframework.http.ResponseEntity;

public interface IUpdateUserService {
    ResponseEntity<UserResponseDto> updateUserPasswordById(Integer id, String password);
    ResponseEntity<UserResponseDto> updateUserRoleById(Integer roleId, Integer userId);

}
