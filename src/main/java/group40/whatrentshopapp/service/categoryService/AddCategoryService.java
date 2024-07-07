package group40.whatrentshopapp.service.categoryService;


import group40.whatrentshopapp.domain.Category;
import group40.whatrentshopapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentshopapp.exception_handling.exceptions.AlreadyExistException;
import group40.whatrentshopapp.repository.ICategoryRepository;
import group40.whatrentshopapp.service.interfaces.categorySericeInterface.IAddCategoryService;
import group40.whatrentshopapp.service.mapping.CategoryConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AddCategoryService implements IAddCategoryService {

    private final ICategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Override
    public ResponseEntity<CategoryResponseDto> addCategory(CategoryRequestDto requestDto) {

        if (categoryRepository.findByCategoryName(requestDto.getCategoryName()).isEmpty()) {

            Category newCategory = categoryConverter.convertFromDto(requestDto);
            Category savedNewCategory = categoryRepository.save(newCategory);
            CategoryResponseDto dto = categoryConverter.convertToDto(savedNewCategory);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } else {
            throw new AlreadyExistException("Category already exists");
        }
    }
}
