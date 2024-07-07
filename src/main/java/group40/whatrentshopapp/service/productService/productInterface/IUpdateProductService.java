package group40.whatrentshopapp.service.productService.productInterface;

import group40.whatrentshopapp.dto.productDto.ProductRequestDto;
import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

public interface IUpdateProductService {
    ResponseEntity<ProductResponseDto> updateProduct(Integer productId, ProductRequestDto productRequestDto);
}
