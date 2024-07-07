package group40.whatrentshopapp.repository;

import group40.whatrentshopapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(int id);
    Optional<Category> findByCategoryName(String categoryName);

    @Modifying
    @Query("UPDATE Category c SET c.categoryName = :name WHERE c.id = :id")
    int updateCategoryNameById(@Param("name") String name, @Param("id") Integer id);
}
