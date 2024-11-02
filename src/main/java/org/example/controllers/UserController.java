package org.example.controllers;

import org.example.entity.Client;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getClients(Model model) {
        List<Client> clients = userService.getAll();
        model.addAttribute("clients", clients);
        return "user_list";
    }

    @GetMapping("/{id}")
    public String getOneClient(@PathVariable("id") Long clientId, Model model) {
        Integer totalOrderSum = userService.calculateTotalPurchases(clientId);
        Client client = userService.getClientById(clientId);
        List<Object[]> clientOrder = new ArrayList<>(userService.calculateTotalOrdersClient(clientId));
        model.addAttribute("totalOrderSum", totalOrderSum);
        model.addAttribute("client", client);
        model.addAttribute("clientOrder", clientOrder);
        return "one_user";
    }

    @GetMapping("/addForm")
    public String showAddUserForm(Model model) {
        model.addAttribute("client", new Client());
        return "add_user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute Client client) {
        userService.saveClient(client);
        return "redirect:/user";
    }

    @PostMapping("/{id}/delete")
    public String deleteClient(@PathVariable("id") Long clientId) {
        userService.deleteClient(clientId);
        return "redirect:/user";  // Перенаправляемся на список пользователей после удаления
    }

    @GetMapping("/{id}/edit")
    public String showEditUserForm(@PathVariable("id") Long clientId, Model model) {
        Client client = userService.getClientById(clientId);
        model.addAttribute("client", client);
        return "edit_user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("client") Client client) {
        userService.updateClient(client);
        return "redirect:/user";
    }

//    @PostMapping("/{id}/zakazInfo")
//    public String ShowZakazano(@PathVariable("id") Long clientId) {
//        return ""
//    }
}
