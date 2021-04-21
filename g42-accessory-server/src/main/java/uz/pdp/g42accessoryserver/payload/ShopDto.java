package uz.pdp.g42accessoryserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.g42accessoryserver.entity.User;
import uz.pdp.g42accessoryserver.entity.Warehouse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    private Integer id;
    private String name;
    private String description;
    private String address;
    private UserDto seller;
    private boolean active;


}
