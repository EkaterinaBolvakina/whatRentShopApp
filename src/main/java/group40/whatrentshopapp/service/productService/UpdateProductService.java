package group40.whatrentshopapp.service.productService;

import group40.whatrentshopapp.dto.productDto.ProductRequestDto;
import group40.whatrentshopapp.domain.Product;
import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import group40.whatrentshopapp.repository.IProductRepository;
import group40.whatrentshopapp.service.interfaces.productServiceInterface.IUpdateProductService;
import group40.whatrentshopapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentshopapp.service.mapping.ProductConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UpdateProductService implements IUpdateProductService {
    private final IProductRepository productRepository;
    private final ProductConverter productConverter;

    @Override
    public ResponseEntity<ProductResponseDto> updateProduct(Integer productId, ProductRequestDto productRequestDto) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product productForUpdate = productOptional.get();

            if (productRequestDto.getProductName() != null) {
                productForUpdate.setName(productRequestDto.getProductName());
            }
            if (productRequestDto.getProductDescription() != null) {
                productForUpdate.setDescription(productRequestDto.getProductDescription());
            }
            if (productRequestDto.getProductPrice() != null) {
                productForUpdate.setPrice(productRequestDto.getProductPrice());
            }
            if (productRequestDto.getProductQuantity() != null) {
                productForUpdate.setQuantity(productRequestDto.getProductQuantity());
            }

            if (productRequestDto.getProductCategory() != null) {
                productForUpdate.setCategory(productRequestDto.getProductCategory());
            }

            Product updatedProduct = productRepository.save(productForUpdate);
            ProductResponseDto productResponseDto = productConverter.convertToDto(updatedProduct);
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Product with id = "+ productId +" not found");
        }
    }
}
