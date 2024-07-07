package group40.whatrentshopapp.service.interfaces.categorySericeInterface;

import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindCategoryService {
    ResponseEntity<List<CategoryResponseDto>> findAll();

    ResponseEntity<CategoryResponseDto> findById(Integer id);

    ResponseEntity<CategoryResponseDto> findByName(String categoryName);
}
