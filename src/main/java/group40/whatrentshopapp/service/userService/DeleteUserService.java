package group40.whatrentshopapp.service.userService;


import group40.whatrentshopapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentshopapp.repository.ICategoryRepository;
import group40.whatrentshopapp.repository.IUserRepository;
import group40.whatrentshopapp.service.interfaces.categorySericeInterface.IDeleteCategoryService;
import group40.whatrentshopapp.service.interfaces.userServiceInterface.IDeleteUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserService implements IDeleteUserService {
    private final IUserRepository userRepository;

    @Override
    public ResponseEntity<Void> deleteUserById(Integer userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new NotFoundException("User with id = " + userId + " not found");
        }
    }
}
