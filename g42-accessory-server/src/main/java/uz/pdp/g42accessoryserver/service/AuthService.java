package uz.pdp.g42accessoryserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.g42accessoryserver.entity.User;
import uz.pdp.g42accessoryserver.repository.UserRepository;

import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username+" not found"));
    }

    public User loadByUserId(UUID userId){
        return userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user not found"));
    }
}
