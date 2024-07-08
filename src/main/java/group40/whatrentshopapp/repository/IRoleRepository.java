package group40.whatrentshopapp.repository;

import group40.whatrentshopapp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findById(int id);

    @Modifying
    @Query("UPDATE Role r SET r.name = :name WHERE r.id = :id")
    int updateRoleNameById(@Param("name") String name, @Param("id") Integer id);
}
