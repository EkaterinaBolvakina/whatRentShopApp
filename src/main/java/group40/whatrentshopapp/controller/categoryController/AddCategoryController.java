package group40.whatrentshopapp.controller.categoryController;

import group40.whatrentshopapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentshopapp.service.categoryService.AddCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class AddCategoryController {

    private final AddCategoryService addCategoryService;

    @PostMapping("/addNew")
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryRequestDto requestDto) {
        return addCategoryService.addCategory(requestDto);
    }
}
