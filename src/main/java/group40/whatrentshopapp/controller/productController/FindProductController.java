package group40.whatrentshopapp.controller.productController;

import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import group40.whatrentshopapp.service.productService.FindProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class FindProductController {
    private final FindProductService findProductService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAllProducts() {
        return findProductService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findProductById(@PathVariable Integer id) {
        return findProductService.findById(id);
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<ProductResponseDto>> findProductByName(@RequestParam(value = "productName") String name) {
        return findProductService.findByName(name);
    }

    @GetMapping("/findByDescription")
    public ResponseEntity<List<ProductResponseDto>> findProductByDescription(@RequestParam(value = "productDescription") String description) {
        return findProductService.findByDescription(description);
    }

    @GetMapping("/findByPrice")
    public ResponseEntity<List<ProductResponseDto>> findProductByPrice(@RequestParam(value = "productPrice") Double price) {
        return findProductService.findByPrice(price);
    }

    // localhost:8080/products/findByPrice-Min-Max?priceMin=100&priceMax=200
    @GetMapping("/findByPrice-Min-Max")
    public ResponseEntity<List<ProductResponseDto>> findProductByPriceInterval(@RequestParam(value = "priceMin") Double priceMin, @RequestParam(value = "priceMax") Double priceMax) {
        return findProductService.findByPriceInterval(priceMin, priceMax);
    }

    @GetMapping("/findByQuantity")
    public ResponseEntity<List<ProductResponseDto>> findProductByQuantity(@RequestParam(value = "productQuantity") Integer productQuantity) {
        return findProductService.findByQuantity(productQuantity);
    }

    @GetMapping("/findByQuantity-Min-Max")
    public ResponseEntity<List<ProductResponseDto>> findProductByQuantityInterval(@RequestParam(value = "quantityMin") Integer quantityMin, @RequestParam(value = "quantityMax") Integer quantityMax) {
        return findProductService.findByQuantityInterval(quantityMin, quantityMax);
    }
}
