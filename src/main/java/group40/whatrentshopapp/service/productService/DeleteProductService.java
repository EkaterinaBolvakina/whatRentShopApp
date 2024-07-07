package group40.whatrentshopapp.service.productService;


import group40.whatrentshopapp.repository.IProductRepository;
import group40.whatrentshopapp.service.productService.productInterface.IDeleteProductService;
import group40.whatrentshopapp.service.util.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService implements IDeleteProductService {
    private final IProductRepository productRepository;

    public DeleteProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Integer productId) {

        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new NotFoundException("Product with id = " + productId + " not found");
        }
    }
}
