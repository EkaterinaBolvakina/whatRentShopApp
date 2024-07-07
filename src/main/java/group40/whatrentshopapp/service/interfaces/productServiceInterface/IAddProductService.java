package group40.whatrentshopapp.service.interfaces.productServiceInterface;

import group40.whatrentshopapp.dto.productDto.ProductRequestDto;
import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAddProductService {
    ResponseEntity<ProductResponseDto> addProduct(ProductRequestDto productRequestDto);
}
