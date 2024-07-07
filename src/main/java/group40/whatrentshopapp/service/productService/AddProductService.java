package group40.whatrentshopapp.service.productService;


import group40.whatrentshopapp.dto.productDto.ProductRequestDto;
import group40.whatrentshopapp.domain.Category;
import group40.whatrentshopapp.domain.Product;
import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import group40.whatrentshopapp.repository.ICategoryRepository;
import group40.whatrentshopapp.repository.IProductRepository;
import group40.whatrentshopapp.service.productService.productInterface.IAddProductService;
import group40.whatrentshopapp.service.util.mapping.ProductConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddProductService implements IAddProductService {
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
    private final ProductConverter productConverter;

    @Override
    public ResponseEntity<ProductResponseDto> addProduct(ProductRequestDto productRequestDto) {

        Product newProduct = productConverter.convertFromDto(productRequestDto);
        Optional<Category> defaultCategory = categoryRepository.findById(1);

        if (defaultCategory.isPresent()) {
            newProduct.setCategory(defaultCategory.get());
        }else {
            throw new RuntimeException("Category for new product with name:'" +newProduct.getName()+"' not found");
        }

        Product savedNewProduct = productRepository.save(newProduct);
        ProductResponseDto dto = productConverter.convertToDto(savedNewProduct);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
