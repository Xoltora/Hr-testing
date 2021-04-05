package uz.pdp.g42accessoryserver.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.g42accessoryserver.entity.Role;
import uz.pdp.g42accessoryserver.entity.User;
import uz.pdp.g42accessoryserver.entity.enums.RoleName;
import uz.pdp.g42accessoryserver.repository.RoleRepository;
import uz.pdp.g42accessoryserver.repository.UserRepository;

import java.util.Collections;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.datasource.initialization-mode}")
    private String mode;

    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")){
            Role director = roleRepository.save(new Role(RoleName.ROLE_DIRECTOR));
            userRepository.save(new User(
                    "Director",
                    "Directorov",
                    "+998993632587",
                    "director",
                    passwordEncoder.encode("root123"),
                    Collections.singleton(director)
            ));

        }
    }
}
