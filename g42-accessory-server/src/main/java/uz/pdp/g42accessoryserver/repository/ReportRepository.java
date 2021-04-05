package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.g42accessoryserver.entity.Report;

import java.util.List;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {

    List<Report> findByAcceptedEquals(boolean accepted);

    @Modifying
    @Query("update Report r set r.accepted = true  where r.accepted = false")
    void changeStatus();

}
