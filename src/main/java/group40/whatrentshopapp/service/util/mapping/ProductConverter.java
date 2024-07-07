package group40.whatrentshopapp.service.util.mapping;

import group40.whatrentshopapp.domain.Product;
import group40.whatrentshopapp.dto.productDto.ProductRequestDto;
import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter {
    public Product convertFromDto(ProductRequestDto dto) {
        Product product = new Product();

        if (dto.getProductName() != null) {
            product.setName(dto.getProductName());
        }
        if (dto.getProductDescription() != null) {
            product.setDescription(dto.getProductDescription());
        }

        if (dto.getProductPrice() != null) {
            product.setPrice(dto.getProductPrice());
        }

        if (dto.getProductQuantity() != null) {
            product.setQuantity(dto.getProductQuantity());
        }

        if (dto.getProductCategory() != null) {
            product.setCategory(dto.getProductCategory());
        }
        return product;
    }

    public ProductResponseDto convertToDto(Product product) {

        ProductResponseDto dto = new ProductResponseDto();
        dto.setProductId(product.getId());

        if (product.getName() != null) {
            dto.setProductName(product.getName());
        }
        if (product.getDescription() != null) {
            dto.setProductDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            dto.setProductPrice(product.getPrice());
        }
        if (product.getQuantity() != null) {
            dto.setProductQuantity(product.getQuantity());
        }
        if (product.getCategory() != null) {
            dto.setProductCategory(product.getCategory());
        }
        return dto;
    }
}
