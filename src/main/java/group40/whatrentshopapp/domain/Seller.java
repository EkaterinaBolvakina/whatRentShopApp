package group40.whatrentshopapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="is_active")
    private Boolean isActive;

  //  @OneToOne
  //  @JoinColumn(name = "user_id")
  //  private User ROLE_SELLER;

   // @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
   // private Set<Product> products = new HashSet<>();
}
