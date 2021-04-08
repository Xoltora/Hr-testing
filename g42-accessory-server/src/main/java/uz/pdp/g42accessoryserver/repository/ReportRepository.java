package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.g42accessoryserver.entity.Report;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {


    Page<Report> findByAcceptedEquals(boolean accepted, Pageable pageable);

    @Modifying
    @Query("update Report r set r.accepted = true  where r.accepted = false")
    void changeStatus(boolean accepted);

}
