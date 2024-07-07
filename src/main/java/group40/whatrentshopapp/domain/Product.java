package group40.whatrentshopapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name= "product") // wenn der Name der Tabelle geändert wird, so ist @Table in @Data enthalten
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="product_name")
    //@NotBlank(message = "Product name must be not blank")
    @Size(min=3, max=25, message = "Product name length must be between 3 and 25 characters")
    private String name;

    @Column(name="product_description")
    //@NotBlank(message = "Product description must be not blank")
    @Size(min=3, max=45, message = "Product description length must be between 3 and 45 characters")
    private String description;

    @Column(name="product_price")
    //@NotBlank(message = "Product price must be not blank")
    private Double price;

    @Column(name="product_quantity")
   // @NotBlank(message = "Product quantity must be not blank")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
   // @JsonBackReference (um Endlosschleife zu vermeiden, verwendet man @JsonBackReference und @JsonManagedReference in Category über List<Product>.)
    private Category category;

    public Product(String name, String description, Double price, Integer quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
