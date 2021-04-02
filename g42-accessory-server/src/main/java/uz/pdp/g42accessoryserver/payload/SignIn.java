package uz.pdp.g42accessoryserver.payload;

import lombok.Data;

@Data
public class SignIn {
    private String username;
    private String password;
}
