package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
