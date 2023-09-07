package org.jwt;

import org.jwt.security.models.ERole;
import org.jwt.security.models.RoleEntity;
import org.jwt.security.models.UserEntity;
import org.jwt.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	@Bean
	CommandLineRunner init()
	{
		return args -> {
			UserEntity user = UserEntity.builder()
					.email("stiven@gmail.com")
					.name("Stiven")
					.enabled(true)
					.lastName("Molina")
					.username("stivenmolina")
					.phone(12345678L)
					.address("tercera Calle Poniente")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();
			UserEntity user2 = UserEntity.builder()
					.email("molina@gmail.com")
					.name("Ramiro")
					.enabled(true)
					.lastName("Guerra")
					.username("ramiroguerra")
					.phone(1234278L)
					.address("Unknown")
					.password(passwordEncoder.encode("12345"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.CUSTOMER.name()))
							.build()))
					.build();

			userRepository.save(user);
			userRepository.save(user2);

		};
	}

}
