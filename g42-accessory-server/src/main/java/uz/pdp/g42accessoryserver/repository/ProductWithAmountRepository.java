package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.ProductWithAmount;
import uz.pdp.g42accessoryserver.entity.Transfer;

import java.util.UUID;

public interface ProductWithAmountRepository extends JpaRepository<ProductWithAmount, UUID> {
}
