package group40.whatrentshopapp.service.productService.productInterface;

import org.springframework.http.ResponseEntity;

public interface IDeleteProductService {

    ResponseEntity<Void> deleteProductById(Integer productId);

}
