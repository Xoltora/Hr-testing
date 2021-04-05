package uz.pdp.g42accessoryserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.g42accessoryserver.entity.Address;
import uz.pdp.g42accessoryserver.entity.User;
import uz.pdp.g42accessoryserver.entity.Warehouse;
import uz.pdp.g42accessoryserver.entity.enums.RoleName;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    private Integer id;
    private User manager;
    private List<User> sellersList;
    private Address address;
    private Warehouse warehouse;

    public ShopDto(Integer id, User manager, Address address, List<User> sellersList) {

        this.id = id;
        this.manager = manager;
        this.address = address;
        this.sellersList = sellersList;
    }
}
