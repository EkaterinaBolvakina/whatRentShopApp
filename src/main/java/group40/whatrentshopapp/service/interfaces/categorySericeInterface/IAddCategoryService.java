package group40.whatrentshopapp.service.interfaces.categorySericeInterface;

import group40.whatrentshopapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAddCategoryService {
    ResponseEntity<CategoryResponseDto> addCategory(CategoryRequestDto requestDto);
}
