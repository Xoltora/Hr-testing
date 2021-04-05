package uz.pdp.g42accessoryserver.payload;

import lombok.Data;
import uz.pdp.g42accessoryserver.entity.Address;
import uz.pdp.g42accessoryserver.entity.Shop;
import uz.pdp.g42accessoryserver.entity.User;

import java.util.List;

@Data
public class WarehouseDto {
    private Integer id;
    private String name;
    private String description;
    private List<User> warehouseKeepers;
    private Address address;
    private Shop shop;
}
