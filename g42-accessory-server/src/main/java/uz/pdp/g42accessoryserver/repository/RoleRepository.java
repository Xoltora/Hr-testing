package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
