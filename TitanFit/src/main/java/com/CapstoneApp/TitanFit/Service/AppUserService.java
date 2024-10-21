package com.CapstoneApp.TitanFit.Service;

import com.CapstoneApp.TitanFit.Model.AppUser;
import com.CapstoneApp.TitanFit.Model.Role;
import com.CapstoneApp.TitanFit.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser getUserById(Long id) {
        return appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void saveUser(AppUser user) {
        if(appUserRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if(user.getRole() == null ){
            user.setRole(Role.USER);
        }
        appUserRepository.save(user);
    }

    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    public AppUser updateUser(Long id, AppUser userDetails) {
        AppUser user = getUserById(id);
        user.setEmail(userDetails.getEmail());
        if(userDetails.getPassword() != null && userDetails.getPassword().length() > 0) {
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }
        if(userDetails.getRole() != null) {
            user.setRole(userDetails.getRole());
        }
        return appUserRepository.save(user);
    }

    public void deleteUser(Long id) {
        AppUser user = getUserById(id);
        appUserRepository.deleteById(id);
    }


    public AppUser getCurrentUser() {
        // Logic to fetch the currently authenticated user from the security context
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
