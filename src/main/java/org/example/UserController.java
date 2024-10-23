package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository; // Должен быть интерфейс, а не сервис

    @Autowired
    public UserController(UserRepository userRepository) { // Измените здесь
        this.userRepository = userRepository; // Внедряем UserRepository
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userRepository.findAll(); // Используйте экземпляр userRepository
        model.addAttribute("users", users); // Добавляем пользователей в модель
        return "user_list";
    }
}
