package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class App implements CommandLineRunner {

    private final UserService userService;

    public App(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Можно вызвать метод для получения пользователей сразу после запуска приложения
        userService.getAllUsers().forEach(user ->
                System.out.println("User: " + user.getFio())
        );
    }
}
