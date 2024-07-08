package group40.whatrentshopapp.service.userService;

import group40.whatrentshopapp.domain.User;
import group40.whatrentshopapp.dto.roleDto.RoleResponseDto;
import group40.whatrentshopapp.dto.userDto.UserResponseDto;
import group40.whatrentshopapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentshopapp.repository.IUserRepository;
import group40.whatrentshopapp.service.interfaces.userServiceInterface.IUpdateUserService;
import group40.whatrentshopapp.service.mapping.UserConverter;
import group40.whatrentshopapp.service.roleService.FindRoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UpdateUserService implements IUpdateUserService {
    private final IUserRepository userRepository;
    private final UserConverter userConverter;
    private final FindRoleService findRoleService;

    @Override
    @Transactional
    public ResponseEntity<UserResponseDto> updateUserPasswordById(Integer id, String password) {
        if (userRepository.existsById(id)) {
            userRepository.updateUserPasswortById(password, id);
            User updatedUser = userRepository.findUserById(id).get();
            UserResponseDto userResponseDto = userConverter.convertToDto(updatedUser);
            return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("User with id = " + id + " not found");
        }
    }

    @Override
    public ResponseEntity<UserResponseDto> updateUserRoleById(Integer roleId, Integer userId) {
        ResponseEntity<RoleResponseDto> roleResponseEntity = findRoleService.findById(roleId);

        if (roleResponseEntity.getStatusCode() == HttpStatus.OK) {
            if (userRepository.existsById(userId)) {
                userRepository.updateUserRoleById(roleId, userId);
                User updatedUser = userRepository.findUserById(userId).orElseThrow(() -> new NotFoundException("User with id = " + userId + " not found"));
                UserResponseDto userResponseDto = userConverter.convertToDto(updatedUser);
                return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
            } else {
                throw new NotFoundException("User with id = " + userId + " not found");
            }
        } else {
            throw new NotFoundException("Role with id = " + roleId + " not found");
        }
    }
}
