package group40.whatrentshopapp.service.productService.productInterface;

import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindProductService {
    ResponseEntity<List<ProductResponseDto>> findAll();
    ResponseEntity<ProductResponseDto> findById(Integer id);
    ResponseEntity<List<ProductResponseDto>> findByName(String productName);
    ResponseEntity<List<ProductResponseDto>> findByDescription(String productDescription);
    ResponseEntity<List<ProductResponseDto>> findByPrice(Double productPrice);
    ResponseEntity<List<ProductResponseDto>> findByQuantity(Integer productQuantity);
    ResponseEntity<List<ProductResponseDto>> findByPriceInterval(Double productPriceMin, Double productPriceMax);
    ResponseEntity<List<ProductResponseDto>> findByQuantityInterval(Integer productQuantityMin, Integer productQuantityMax);
}
