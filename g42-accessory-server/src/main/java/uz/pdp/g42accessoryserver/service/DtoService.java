package uz.pdp.g42accessoryserver.service;

import org.springframework.stereotype.Service;
import uz.pdp.g42accessoryserver.entity.Role;
import uz.pdp.g42accessoryserver.entity.Shop;
import uz.pdp.g42accessoryserver.entity.User;
import uz.pdp.g42accessoryserver.entity.Warehouse;
import uz.pdp.g42accessoryserver.payload.ShopDto;
import uz.pdp.g42accessoryserver.payload.UserDto;
import uz.pdp.g42accessoryserver.payload.WarehouseDto;

import java.util.stream.Collectors;

@Service
public class DtoService {

    public WarehouseDto warehouseDto(Warehouse warehouse){
        return new WarehouseDto(
                warehouse.getId(),
                warehouse.getName(),
                warehouse.getDescription(),
                warehouse.getAddress()
        );
    }

    public ShopDto shopDto(Shop shop){
        return new ShopDto(
               shop.getId(),
               shop.getName(),
               shop.getDescription(),
               shop.getAddress(),
                userDto(shop.getSeller()),
                shop.isActive()
        );
    }

    public UserDto userDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getUsername(),
                user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList())
        );
    }
}
