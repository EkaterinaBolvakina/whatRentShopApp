package group40.whatrentshopapp.service.userService;


import group40.whatrentshopapp.domain.Category;
import group40.whatrentshopapp.domain.Role;
import group40.whatrentshopapp.domain.User;
import group40.whatrentshopapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentshopapp.dto.userDto.UserRequestDto;
import group40.whatrentshopapp.dto.userDto.UserResponseDto;
import group40.whatrentshopapp.exception_handling.exceptions.AlreadyExistException;
import group40.whatrentshopapp.repository.ICategoryRepository;
import group40.whatrentshopapp.repository.IUserRepository;
import group40.whatrentshopapp.service.interfaces.categorySericeInterface.IAddCategoryService;
import group40.whatrentshopapp.service.interfaces.userServiceInterface.IAddUserService;
import group40.whatrentshopapp.service.mapping.CategoryConverter;
import group40.whatrentshopapp.service.mapping.UserConverter;
import group40.whatrentshopapp.service.roleService.FindRoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddUserService implements IAddUserService {

    private final IUserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public ResponseEntity<UserResponseDto> addUser(UserRequestDto userRequestDto) {

        if (userRepository.findUserByEmail(userRequestDto.getEmail()).isEmpty()) {

            User newUser = userConverter.convertFromDto(userRequestDto);
            User savedNewUser = userRepository.save(newUser);
            UserResponseDto dto = userConverter.convertToDto(savedNewUser);

            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } else {
            throw new AlreadyExistException("User with email '"+userRequestDto.getEmail()+"' already exists");
        }
    }


}
