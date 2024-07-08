package group40.whatrentshopapp.service.interfaces.userServiceInterface;

import org.springframework.http.ResponseEntity;

public interface IDeleteUserService {
    ResponseEntity<Void> deleteUserById(Integer userId);
}
