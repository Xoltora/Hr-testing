package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.Defect;
import uz.pdp.g42accessoryserver.entity.Reject;

import java.util.UUID;

public interface DefectRepository extends JpaRepository<Defect, UUID> {
}
