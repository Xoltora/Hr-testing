package uz.pdp.g42accessoryserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g42accessoryserver.entity.Trade;
import uz.pdp.g42accessoryserver.entity.Transfer;

import java.util.UUID;

public interface TradeRepository extends JpaRepository<Trade, UUID> {
}
