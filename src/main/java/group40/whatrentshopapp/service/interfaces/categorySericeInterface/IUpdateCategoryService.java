package group40.whatrentshopapp.service.interfaces.categorySericeInterface;

import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

public interface IUpdateCategoryService {
    ResponseEntity<CategoryResponseDto> updateCategoryNameById(Integer id, String name);
}
