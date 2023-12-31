package org.jwt.security.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String address;
    private Boolean enabled;
    private Long phone;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private Set<String> roles;
}
