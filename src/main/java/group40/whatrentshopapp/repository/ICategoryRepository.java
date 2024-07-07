package group40.whatrentshopapp.repository;

import group40.whatrentshopapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(int id);
    Optional<Category> findByCategoryName(String categoryName);
}
