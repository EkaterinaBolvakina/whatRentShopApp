package group40.whatrentshopapp.service.interfaces.categorySericeInterface;

import org.springframework.http.ResponseEntity;

public interface IDeleteCategoryService {
    ResponseEntity<Void> deleteCategoryById(Integer categoryId);
}
