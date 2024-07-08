package group40.whatrentshopapp.service.userService;

import group40.whatrentshopapp.domain.User;
import group40.whatrentshopapp.dto.userDto.UserResponseDto;
import group40.whatrentshopapp.exception_handling.exceptions.IsEmptyException;
import group40.whatrentshopapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentshopapp.repository.IUserRepository;
import group40.whatrentshopapp.service.interfaces.userServiceInterface.IFindUserService;
import group40.whatrentshopapp.service.mapping.UserConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindUserService implements IFindUserService {
    private final IUserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<User> allUsers = userRepository.findAll();
        List<UserResponseDto> allUsersDto = allUsers.stream()
                .map(userConverter::convertToDto)
                .toList();
        if (!allUsers.isEmpty()) {
            return new ResponseEntity<>(allUsersDto, HttpStatus.OK);
        } else {
            throw new IsEmptyException("No user exists");
        }
    }

    @Override
    public ResponseEntity<UserResponseDto> findUserByUsername(String username) {
        Optional<User> foundedUserOptional = userRepository.findUserByUsername(username);

        if (foundedUserOptional.isPresent()) {
            UserResponseDto foundedUserDto = userConverter.convertToDto(foundedUserOptional.get());
            return new ResponseEntity<>(foundedUserDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("User with username '" + username + "' not found");
        }
    }

    @Override
    public ResponseEntity<List<UserResponseDto>> findUserByRole(Integer roleId) {
        List<User> allUsers = userRepository.findUserByRole(roleId);
        List<UserResponseDto> allUsersDto = allUsers.stream()
                .map(userConverter::convertToDto)
                .toList();
        if (!allUsers.isEmpty()) {
            return new ResponseEntity<>(allUsersDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("No user with role id = " + roleId + " is found");
        }
    }

    @Override
    public ResponseEntity<UserResponseDto> findUserById(Integer id) {
        Optional<User> foundedUserOptional = userRepository.findUserById(id);

        if (foundedUserOptional.isPresent()) {
            UserResponseDto foundedUserDto = userConverter.convertToDto(foundedUserOptional.get());
            return new ResponseEntity<>(foundedUserDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("User with id = " + id + " not found");
        }
    }

    @Override
    public ResponseEntity<UserResponseDto> findUserByEmail(String email) {
        Optional<User> foundedUserOptional = userRepository.findUserByEmail(email);

        if (foundedUserOptional.isPresent()) {
            UserResponseDto foundedUserDto = userConverter.convertToDto(foundedUserOptional.get());
            return new ResponseEntity<>(foundedUserDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("User with email '" + email + "' not found");
        }
    }
}
