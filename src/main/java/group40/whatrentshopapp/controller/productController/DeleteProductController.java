package group40.whatrentshopapp.controller.productController;

import group40.whatrentshopapp.service.productService.DeleteProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class DeleteProductController {
    private final DeleteProductService deleteProductService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer id) {
        return deleteProductService.deleteProductById(id);
    }
}
