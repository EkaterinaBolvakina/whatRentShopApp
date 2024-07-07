package group40.whatrentshopapp.service.productService;

import group40.whatrentshopapp.domain.Product;
import group40.whatrentshopapp.dto.productDto.ProductResponseDto;
import group40.whatrentshopapp.repository.IProductRepository;
import group40.whatrentshopapp.service.interfaces.productServiceInterface.IFindProductService;
import group40.whatrentshopapp.exception_handling.exceptions.IsEmptyException;
import group40.whatrentshopapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentshopapp.service.mapping.ProductConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindProductService implements IFindProductService {
    private final IProductRepository productRepository;
    private final ProductConverter productConverter;

    @Override
    public ResponseEntity<List<ProductResponseDto>> findAll() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductResponseDto> allProductsDto = allProducts.stream()
                .map(productConverter::convertToDto)
                .toList();
        if (!allProducts.isEmpty()) {
            return new ResponseEntity<>(allProductsDto, HttpStatus.OK);
        } else {
            throw new IsEmptyException("No product exists");
        }
    }

    @Override
    public ResponseEntity<ProductResponseDto> findById(Integer id) {
        Optional<Product> foundedProductOptional = productRepository.findById(id);

        if (foundedProductOptional.isPresent()) {
            ProductResponseDto foundedProductDto = productConverter.convertToDto(foundedProductOptional.get());
            return new ResponseEntity<>(foundedProductDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Product with id = " + id + " not found");
        }
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> findByName(String productName) {
        List<Product> allProductsFoundedByName = productRepository.findAllByNameContains(productName);
        List<ProductResponseDto> allProductsFoundedByNameDto = allProductsFoundedByName.stream()
                .map(productConverter::convertToDto).toList();

        if (!allProductsFoundedByName.isEmpty()) {
            return new ResponseEntity<>(allProductsFoundedByNameDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("No product with name '" + productName + "' is found");
        }
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> findByDescription(String productDescription) {
        List<Product> allProductsFoundedByDescription = productRepository.findAllByDescriptionContains(productDescription);
        List<ProductResponseDto> allProductsFoundedByDescriptionDto = allProductsFoundedByDescription.stream()
                .map(productConverter::convertToDto).toList();
        if (!allProductsFoundedByDescription.isEmpty()) {
            return new ResponseEntity<>(allProductsFoundedByDescriptionDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("No product with description '" + productDescription + "' is found");
        }
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> findByPrice(Double productPrice) {
        List<Product> allProductsFoundedByPrice = productRepository.findAllByPriceEquals(productPrice);
        List<ProductResponseDto> allProductsFoundedByPriceDto = allProductsFoundedByPrice.stream()
                .map(productConverter::convertToDto).toList();
        if (!allProductsFoundedByPrice.isEmpty()) {
            return new ResponseEntity<>(allProductsFoundedByPriceDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("No product with price = " + productPrice + " is found");
        }
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> findByQuantity(Integer productQuantity) {
        List<Product> allProductsFoundedByQuantity = productRepository.findAllByQuantityEquals(productQuantity);
        List<ProductResponseDto> allProductsFoundedByQuantityDto = allProductsFoundedByQuantity.stream()
                .map(productConverter::convertToDto).toList();
        if (!allProductsFoundedByQuantity.isEmpty()) {
            return new ResponseEntity<>(allProductsFoundedByQuantityDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("No product with quantity = " + productQuantity + " is found");
        }
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> findByPriceInterval(Double productPriceMin, Double productPriceMax) {
        List<Product> productsFoundedByPriceInterval = productRepository.findAllByPriceBetween(productPriceMin, productPriceMax);
        List<ProductResponseDto> productsFoundedByPriceIntervalDto = productsFoundedByPriceInterval.stream()
                .map(productConverter::convertToDto).toList();
        if (!productsFoundedByPriceInterval.isEmpty()) {
            return new ResponseEntity<>(productsFoundedByPriceIntervalDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("No product with price between " + productPriceMin +" and "+ productPriceMax+ " is found");
        }
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> findByQuantityInterval(Integer productQuantityMin, Integer productQuantityMax) {
        List<Product> foundedProductsByQuantityInterval = productRepository.findAllByQuantityBetween(productQuantityMin, productQuantityMax);
        List<ProductResponseDto> foundedProductsByQuantityIntervalDto = foundedProductsByQuantityInterval.stream()
                .map(productConverter::convertToDto).toList();
        if (!foundedProductsByQuantityInterval.isEmpty()) {
            return new ResponseEntity<>(foundedProductsByQuantityIntervalDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("No product with quantity between " + productQuantityMin +" and "+ productQuantityMax+ " is found");
        }
    }
}
