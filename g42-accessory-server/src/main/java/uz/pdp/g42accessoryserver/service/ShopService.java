package uz.pdp.g42accessoryserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import uz.pdp.g42accessoryserver.entity.Address;
import uz.pdp.g42accessoryserver.entity.Shop;
import uz.pdp.g42accessoryserver.entity.Warehouse;
import uz.pdp.g42accessoryserver.payload.ApiResponse;
import uz.pdp.g42accessoryserver.payload.ShopDto;
import uz.pdp.g42accessoryserver.repository.AddressRepository;
import uz.pdp.g42accessoryserver.repository.ShopRepository;
import uz.pdp.g42accessoryserver.repository.WarehouseRepository;
import uz.pdp.g42accessoryserver.utills.CommonUtills;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    public ApiResponse saveOrEdit(ShopDto shopDto) {
        try {
            Shop shop = new Shop();
            if (shopDto.getId() != null) {
                shop = shopRepository.findById(shopDto.getId()).orElseThrow(() -> new IllegalStateException("Shop not found"));
            }
            shop.setSellers(shopDto.getSellersList());
            shop.setManager(shopDto.getManager());
            shopRepository.save(shop);

            Optional<Address> optionalAddress = addressRepository.findAddressByName(shopDto.getAddress().toString());
            Address address = optionalAddress.get();
            address.setDistrict(shopDto.getAddress().getDistrict());
            address.setLon(shopDto.getAddress().getLon());
            address.setLat(shopDto.getAddress().getLat());
            address.setHome(shopDto.getAddress().getHome());
            address.setStreet(shopDto.getAddress().getStreet());
            addressRepository.save(address);
            shop.setAddress(address);

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findWarehouseById(shopDto.getId());
            Warehouse warehouse = optionalWarehouse.get();
            warehouse.setShop(shop);
            warehouseRepository.save(warehouse);
            return new ApiResponse(shopDto.getId() != null ? "Edited" : "Saved", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }


    public ApiResponse all(Integer page, Integer size) throws IllegalAccessException {
        Page<Shop> all = shopRepository.findAll(CommonUtills.getPageableByCreatedAtDesc(page, size));
        return new ApiResponse("Ok",true,all.getContent().stream().map(this::getShopDto).collect(Collectors.toList()),all.getTotalElements(),all.getTotalPages());
    }

    public ShopDto getShopDto(Shop shop){
        return new ShopDto(
                shop.getId(),
                shop.getManager(),
                shop.getAddress(),
                shop.getSellers());
    }

    public ApiResponse changeActive(Integer id) {
        try {
            Shop shop =shopRepository.findById(id).orElseThrow(() -> new IllegalStateException("Shop not found"));
            shop.setEnabled(!shop.isEnabled());
           shopRepository.save(shop);
            return new ApiResponse(shop.isEnabled()?"Activated":"Blocked", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ApiResponse("Error", false);
    }

}
