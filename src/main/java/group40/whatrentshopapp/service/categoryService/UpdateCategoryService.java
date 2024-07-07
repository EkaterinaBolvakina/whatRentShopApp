package group40.whatrentshopapp.service.categoryService;

import group40.whatrentshopapp.domain.Category;
import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentshopapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentshopapp.repository.ICategoryRepository;
import group40.whatrentshopapp.service.interfaces.categorySericeInterface.IUpdateCategoryService;
import group40.whatrentshopapp.service.mapping.CategoryConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UpdateCategoryService implements IUpdateCategoryService {
    private final ICategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Override
    @Transactional
    public ResponseEntity<CategoryResponseDto> updateCategoryNameById(Integer id, String name) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.updateCategoryNameById(name, id);
            Category updatedCategory = categoryRepository.findById(id).get();
            CategoryResponseDto categoryResponseDto = categoryConverter.convertToDto(updatedCategory);
            return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Category with id = " + id + " not found");
        }
    }
}
