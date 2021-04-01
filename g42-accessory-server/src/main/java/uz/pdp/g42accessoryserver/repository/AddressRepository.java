package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.Address;
import uz.pdp.g42accessoryserver.entity.District;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
