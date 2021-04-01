package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.District;
import uz.pdp.g42accessoryserver.entity.Region;

public interface DistrictRepository extends JpaRepository<District,Integer> {
}
