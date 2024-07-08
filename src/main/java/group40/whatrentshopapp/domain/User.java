package group40.whatrentshopapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Username must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username can contain only latin character and digital")
    private String username;

    @NotBlank(message = "User passwort must be not blank")
    @Size(min = 7, max = 15, message = "Password length must be between 7 and 15 characters")
    private String password;

    @Email(message = "Invalid email format")
    @NotBlank(message = "User email must be not blank")
    private String email;

    //@NotBlank(message = "User first name must be not blank")
    private String firstName;
    //@NotBlank(message = "User last name must be not blank")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "ROLE_SELLER", cascade = CascadeType.ALL, orphanRemoval = true)
    private Inventory inventory;

    @OneToMany(mappedBy = "ROLE_BUYER", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cart> carts = new HashSet<>();
}
