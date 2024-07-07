package group40.whatrentshopapp.service.interfaces.productServiceInterface;

import org.springframework.http.ResponseEntity;

public interface IDeleteProductService {

    ResponseEntity<Void> deleteProductById(Integer productId);

}
