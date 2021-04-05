package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop,Integer> {

}
