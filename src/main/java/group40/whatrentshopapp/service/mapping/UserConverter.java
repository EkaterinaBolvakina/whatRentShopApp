package group40.whatrentshopapp.service.mapping;

import group40.whatrentshopapp.domain.User;
import group40.whatrentshopapp.dto.userDto.UserRequestDto;
import group40.whatrentshopapp.dto.userDto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public User convertFromDto(UserRequestDto userRequestDto) {
        User user = new User();
        if (userRequestDto.getUsername() != null) {
            user.setUsername(userRequestDto.getUsername());
        }
        if (userRequestDto.getPassword() != null) {
            user.setPassword(userRequestDto.getPassword());
        }
        if (userRequestDto.getEmail() != null) {
            user.setEmail(userRequestDto.getEmail());
        }
        if (userRequestDto.getFirstName() != null) {
            user.setFirstName(userRequestDto.getFirstName());
        }
        if (userRequestDto.getLastName() != null) {
            user.setLastName(userRequestDto.getLastName());
        }
        return user;
    }


    public UserResponseDto convertToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());

        if (user.getUsername() != null) {
            userResponseDto.setUsername(user.getUsername());
        }
        if (user.getEmail() != null) {
            userResponseDto.setEmail(user.getEmail());
        }
        if (user.getFirstName() != null) {
            userResponseDto.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            userResponseDto.setLastName(user.getLastName());
        }
        if (user.getRole() != null) {
            userResponseDto.setRole(user.getRole());
        }
        return userResponseDto;
    }
}