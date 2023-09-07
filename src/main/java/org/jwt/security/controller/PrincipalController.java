package org.jwt.security.controller;

import jakarta.validation.Valid;
import org.jwt.security.controller.request.CreateUserDTO;
import org.jwt.security.models.ERole;
import org.jwt.security.models.RoleEntity;
import org.jwt.security.models.UserEntity;
import org.jwt.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/hello")
    public String hello(){
        return "Hello World Not Secured";
    }
    @GetMapping("/helloSecured")
    public String helloSecured(){
        return "Hello World Secured";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){

        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role->RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .address(createUserDTO.getAddress())
                .email(createUserDTO.getEmail())
                .phone(createUserDTO.getPhone())
                .name(createUserDTO.getName())
                .enabled(createUserDTO.getEnabled())
                .lastName(createUserDTO.getLastName())
                .roles(roles)
        .build();
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Deleted Successful";
    }

}
