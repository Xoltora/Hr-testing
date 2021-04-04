package uz.pdp.g42accessoryserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.g42accessoryserver.entity.enums.RoleName;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
    private RoleName roleName;
    private List<RoleName> roleNameList;

    public UserDto(UUID id, String firstName, String lastName, String phoneNumber, String username, List<RoleName> roleNameList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.roleNameList = roleNameList;
    }
}
