package uz.pdp.g42accessoryserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.g42accessoryserver.entity.Shop;
import uz.pdp.g42accessoryserver.entity.User;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    private UUID id;

    private Shop shop;

    private User seller;

    private User manager;

    private boolean accepted;

}
