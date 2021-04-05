package uz.pdp.g42accessoryserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.g42accessoryserver.entity.Category;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private UUID id;
    private Category category;
    private String name;
    private double incomePrice;
    private double salePrice;
    private int norma;
    private boolean active;
}
