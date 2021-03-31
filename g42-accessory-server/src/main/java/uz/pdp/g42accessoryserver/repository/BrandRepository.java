package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
