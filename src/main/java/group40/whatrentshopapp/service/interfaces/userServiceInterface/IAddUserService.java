package group40.whatrentshopapp.service.interfaces.userServiceInterface;

import group40.whatrentshopapp.dto.userDto.UserRequestDto;
import group40.whatrentshopapp.dto.userDto.UserResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAddUserService {
    ResponseEntity<UserResponseDto> addUser(UserRequestDto userRequestDto);
}
