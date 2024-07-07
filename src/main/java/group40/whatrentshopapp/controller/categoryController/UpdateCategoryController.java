package group40.whatrentshopapp.controller.categoryController;

import group40.whatrentshopapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentshopapp.service.categoryService.UpdateCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class UpdateCategoryController {
    private final UpdateCategoryService updateCategoryService;

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategoryNameById(@PathVariable Integer id, @RequestBody CategoryRequestDto categoryRequestDto) {
        return updateCategoryService.updateCategoryNameById(id, categoryRequestDto.getCategoryName());
    }
}
