package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.Report;
import uz.pdp.g42accessoryserver.entity.Transfer;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {
}
