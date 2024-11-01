package org.example.controllers;

import org.example.entity.Client;
import org.example.entity.Point;
import org.example.entity.Postavchik;
import org.example.entity.Tovar;
import org.example.DataService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MenuController {

    private final DataService<Client> clientService;
    private final DataService<Tovar> tovarService;
    private final DataService<Point> pointService;
    private final DataService<Postavchik> postavchikService;
    private final UserService userService;

    @Autowired
    public MenuController(DataService<Client> clientService,
                          DataService<Tovar> tovarService,
                          DataService<Point> pointService,
                          DataService<Postavchik> postavchikService,
                          UserService userService) { // Внедряем UserService
        this.clientService = clientService;
        this.tovarService = tovarService;
        this.pointService = pointService;
        this.postavchikService = postavchikService;
        this.userService = userService; // Инициализируем UserService
    }

    @GetMapping("/user")
    public String getClients(Model model) {
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "user_list";
    }

    @GetMapping("/tovar")
    public String getTovars(Model model) {
        List<Tovar> tovars = tovarService.getAll();
        model.addAttribute("tovars", tovars); // Изменено на "tovars"
        return "tovar_list";
    }

    @GetMapping("/point")
    public String getPoints(Model model) {
        List<Point> points = pointService.getAll();
        model.addAttribute("points", points); // Изменено на "points"
        return "point_list";
    }

    @GetMapping("/postavchik")
    public String getPostavchiks(Model model) {
        List<Postavchik> postavchiks = postavchikService.getAll();
        model.addAttribute("postavchiks", postavchiks); // Изменено на "postavchiks"
        return "postavchik_list";
    }
    @GetMapping("/user/{id}")
    public String getOneClient(@PathVariable("id") Long clientId, Model model) {
        Integer totalOrderSum = userService.calculateTotalPurchases(clientId);
        Client client = userService.getClientById(clientId); // Метод для поиска клиента по ID

        model.addAttribute("totalOrderSum", totalOrderSum);
        model.addAttribute("client", client);
        return "one_user";
    }
    @GetMapping("/user/addForm")
    public String showAddUserForm(Model model) {
        model.addAttribute("client", new Client());
        return "add_user";
    }

    // Метод для обработки добавления пользователя
    @PostMapping("/user/add")
    public String addUser(@ModelAttribute Client client) {
        userService.saveClient(client);
        return "redirect:/user";  // Возвращаемся к списку пользователей после добавления
    }
    // Метод для отображения формы редактирования пользователя
    @GetMapping("/user/{id}/edit")
    public String showEditUserForm(@PathVariable("id") Long clientId, Model model) {
        Client client = userService.getClientById(clientId);
        model.addAttribute("client", client);
        return "edit_user";
    }

    // Метод для сохранения изменений
    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute("client") Client client) {
        userService.updateClient(client);
        return "redirect:/user";  // Возвращаемся к списку пользователей после сохранения
    }

}
