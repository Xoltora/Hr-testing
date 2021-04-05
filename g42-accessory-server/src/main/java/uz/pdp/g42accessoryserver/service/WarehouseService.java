package uz.pdp.g42accessoryserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import uz.pdp.g42accessoryserver.entity.Warehouse;
import uz.pdp.g42accessoryserver.payload.ApiResponse;
import uz.pdp.g42accessoryserver.payload.WarehouseDto;
import uz.pdp.g42accessoryserver.repository.WarehouseRepository;
import uz.pdp.g42accessoryserver.utills.CommonUtills;


@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public ApiResponse all(Integer page, Integer size){
        try {
            Page<Warehouse> all = warehouseRepository
                    .findAll(CommonUtills.getPageableByCreatedAtDesc(page, size));
            return new ApiResponse(
                    "Success",
                    true,
                    all.getContent(),
                    all.getTotalElements(),
                    all.getTotalPages());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse saveOrEdit(WarehouseDto whdto) {
        try {
            Warehouse warehouse = new Warehouse();
            if (whdto.getId() != null) {
                warehouse = warehouseRepository.findById(whdto.getId())
                        .orElseThrow(() -> new IllegalStateException("WareHouse not found"));
            }
            warehouse.setAddress(whdto.getAddress());
            warehouse.setName(warehouse.getName());
            warehouse.setDescription(whdto.getDescription());
            warehouse.setShop(whdto.getShop());
            warehouse.setWarehouseKeepers(warehouse.getWarehouseKeepers());
            warehouseRepository.save(warehouse);
            return new ApiResponse(whdto.getId() != null ? "Edited" : "Saved", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse changeActive(Integer id){
        try{
            Warehouse warehouse = warehouseRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("WareHouse not found"));
            warehouse.setActive(!warehouse.isActive());
            warehouseRepository.save(warehouse);
            return new ApiResponse(warehouse.isActive()?"Activated":"Blocked", true);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse remove(Integer id){
        try{
            warehouseRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("WareHouse not found"));
            warehouseRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }
}
