package group40.whatrentshopapp.service.interfaces.userServiceInterface;

import group40.whatrentshopapp.dto.userDto.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindUserService {
    ResponseEntity<List<UserResponseDto>> findAll();
    ResponseEntity<UserResponseDto> findUserById(Integer id);
    ResponseEntity<UserResponseDto> findUserByEmail(String email);
    ResponseEntity<UserResponseDto> findUserByUsername(String username);
    ResponseEntity<List<UserResponseDto>> findUserByRole(Integer roleId);
}
