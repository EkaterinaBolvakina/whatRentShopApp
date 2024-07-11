package group40.whatrentshopapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

    @Column(name = "seller_business_name", nullable = false)
    private String businessName;

    @Column(name = "contact_email", nullable = false)
    @Email
    private String contactEmail;

    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;

    @Column(name = "seller_rating")
    private Double rating;

    @Column(name="is_active")
    private Boolean isActive;

  //  @OneToOne
  //  @JoinColumn(name = "user_id")
  //  private User ROLE_SELLER;

   // @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
   // private Set<Product> products = new HashSet<>();
}
