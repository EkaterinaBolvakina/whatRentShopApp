package group40.whatrentshopapp.controller.productController;

import group40.whatrentshopapp.dto.productDto.ProductRequestDto;
import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import group40.whatrentshopapp.service.productService.UpdateProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class UpdateProductController {
    private final UpdateProductService updateProductService;

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Integer id, @RequestBody ProductRequestDto productRequestDto) {
        return updateProductService.updateProduct(id, productRequestDto);
    }
}
