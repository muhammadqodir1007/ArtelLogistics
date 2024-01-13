package com.example.artel;

import com.example.artel.auth.AuthenticationService;
import com.example.artel.auth.RegisterRequest;
import com.example.artel.repository.UserRepository;
import com.example.artel.user.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

import static com.example.artel.user.Role.ADMIN;

@SpringBootApplication
@AllArgsConstructor
public class ArtelApplication {
    private final UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(ArtelApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            Optional<User> user = userRepository.findByUsername("adminartel");
            if (user.isEmpty()) {
                var admin = RegisterRequest.builder()
                        .username("adminartel")
                        .password("ADMIN2024")
                        .role(ADMIN)
                        .build();
                System.out.println("Admin token: " + service.register(admin).getAccessToken());
            } else {
                User user1 = user.get();
                System.out.println("Admin token: " + user1.getTokens().get(0).token);


            }



        };
    }

}
