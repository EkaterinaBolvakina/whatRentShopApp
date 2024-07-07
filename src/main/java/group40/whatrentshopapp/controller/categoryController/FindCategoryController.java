package group40.whatrentshopapp.controller.categoryController;

import group40.whatrentshopapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentshopapp.service.categoryService.FindCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class FindCategoryController {
    private final FindCategoryService findCategoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> findAllCategories() {
        return findCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> findCategoryById(@PathVariable Integer id) {
        return findCategoryService.findById(id);
    }

    // localhost:8080/categories/findByName?categoryName=Category 3
    @GetMapping("/findByName")
    public ResponseEntity<CategoryResponseDto> findCategoryByName(@RequestParam(value = "categoryName") String name) {
        return findCategoryService.findByName(name);
    }
}
