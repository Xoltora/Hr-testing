package uz.pdp.g42accessoryserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.g42accessoryserver.entity.Role;
import uz.pdp.g42accessoryserver.entity.User;
import uz.pdp.g42accessoryserver.entity.enums.RoleName;
import uz.pdp.g42accessoryserver.payload.ApiResponse;
import uz.pdp.g42accessoryserver.payload.UserDto;
import uz.pdp.g42accessoryserver.repository.RoleRepository;
import uz.pdp.g42accessoryserver.repository.UserRepository;
import uz.pdp.g42accessoryserver.utills.CommonUtills;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    public ApiResponse saveOrEdit(UserDto dto, User currentUser) {
        try {
            User user = new User();
            if (dto.getId() != null) {
                user = userRepository.findById(dto.getId()).orElseThrow(() -> new IllegalStateException("User not found"));
            }
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setPhoneNumber(dto.getPhoneNumber());
            user.setUsername(dto.getUsername());
            if (dto.getPassword() != null && (hasRole(currentUser, RoleName.ROLE_DIRECTOR) || hasRole(currentUser, RoleName.ROLE_MANAGER))) {
                user.setPassword(passwordEncoder.encode(dto.getPassword()));
            }
            if (dto.getRoleName() != null && !dto.getRoleName().equals(RoleName.ROLE_DIRECTOR)) {
                user.setRoles(Collections.singleton(roleRepository.findByRoleName(dto.getRoleName())));
            }
            userRepository.save(user);
            return new ApiResponse(dto.getId() != null ? "Edited" : "Saved", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("Error", false);
        }
    }

    public ApiResponse changePassword(String oldPassword, String newPassword, User user) {
        try {
            if (passwordEncoder.matches(user.getPassword(), oldPassword)) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                return new ApiResponse("Ok", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ApiResponse("Error", false);
    }

    public boolean hasRole(User user, RoleName roleName) {
        for (Role role : user.getRoles()) {
            if (role.getRoleName().equals(roleName))
                return true;
        }
        return false;
    }

    public ApiResponse changeActive(UUID id) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
            user.setEnabled(!user.isEnabled());
            userRepository.save(user);
            return new ApiResponse(user.isEnabled()?"Activated":"Blocked", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ApiResponse("Error", false);
    }

    public ApiResponse remove(UUID id) {
        try {
            userRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ApiResponse("Error", false);
    }

    public ApiResponse all(Integer page, Integer size) throws IllegalAccessException {
        Page<User> all = userRepository.findAll(CommonUtills.getPageableByCreatedAtDesc(page, size));
        return new ApiResponse("Ok",true,all.getContent().stream().map(this::getUserDto).collect(Collectors.toList()),all.getTotalElements(),all.getTotalPages());
    }

    public UserDto getUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getUsername(),
                user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList())
        );
    }

}
