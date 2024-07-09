package group40.whatrentshopapp.repository;

import group40.whatrentshopapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserById(int id);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);
 //   List<User> findUserByRole(Integer role_id);

    @Modifying
    @Query("UPDATE User u SET u.password = :passwort WHERE u.id = :id")
    int updateUserPasswortById(@Param("passwort") String passwort, @Param("id") Integer id);

    @Modifying
    @Query("UPDATE User u SET u.role = :role_id WHERE u.id = :id")
    int updateUserRoleById(@Param("role") Integer role_id, @Param("id") Integer id);
}
