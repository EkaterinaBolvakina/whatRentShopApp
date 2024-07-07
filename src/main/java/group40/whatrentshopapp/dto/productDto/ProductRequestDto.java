package group40.whatrentshopapp.dto.productDto;

import group40.whatrentshopapp.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productQuantity;
    private Category productCategory;

}
