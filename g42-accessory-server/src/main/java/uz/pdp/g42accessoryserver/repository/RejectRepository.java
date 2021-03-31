package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.Reject;
import uz.pdp.g42accessoryserver.entity.Trade;

import java.util.UUID;

public interface RejectRepository extends JpaRepository<Reject, UUID> {
}
