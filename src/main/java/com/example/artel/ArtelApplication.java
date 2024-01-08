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
            Optional<User> user = userRepository.findByUsername("admin@mail.com");
            if (user.isEmpty()) {
                var admin = RegisterRequest.builder()
                        .username("admin@mail.com")
                        .password("password")
                        .role(ADMIN)
                        .build();
                System.out.println("Admin token: " + service.register(admin).getAccessToken());
            } else {
                User user1 = user.get();
                System.out.println("Admin token: " + user1.getTokens().get(0).token);


            }


//            var manager = RegisterRequest.builder()
////					.firstname("Admin")
////					.lastname("Admin")
//                    .username("manager@mail.com")
//                    .password("password")
//                    .role(MANAGER)
//                    .build();
//            System.out.println("Manager token: " + service.register(manager).getAccessToken());


//            ItemType itemType = new ItemType();
//            itemType.setName("45.06");
//            ItemType itemType1 = new ItemType();
//            itemType1.setName("47.06");
//
//            itemTypeRepository.save(itemType);
//            itemTypeRepository.save(itemType1);
//
//            Category category = new Category();
//            category.setName("salom");
//            Category category1 = new Category();
//            category1.setName("salom1");
//
//            categoryRepository.save(category1);
//            categoryRepository.save(category);
//
//            MaterialType maaterialType = new MaterialType();
//            maaterialType.setName("45.06");
//            MaterialType materialType1 = new MaterialType();
//            materialType1.setName("47.06");
//
//            materialTypeRepository.save(maaterialType);
//            materialTypeRepository.save(materialType1);
//
//            MaterialCategory materialCategory = new MaterialCategory();
//            materialCategory.setName("salom");
//            MaterialCategory materialCategory1 = new MaterialCategory();
//            materialCategory1.setName("salom1");
//
//            materialCategoryRepository.save(materialCategory1);
//            materialCategoryRepository.save(materialCategory);


        };
    }

}
