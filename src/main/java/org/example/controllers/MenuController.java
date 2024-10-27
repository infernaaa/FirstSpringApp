package org.example.controllers;

import org.example.entity.Client;
import org.example.entity.Point;
import org.example.entity.Postavchik;
import org.example.entity.Tovar;
import org.example.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    private final DataService<Client> clientService;
    private final DataService<Tovar> tovarService;
    private final DataService<Point> pointService;
    private final DataService<Postavchik> postavchikService;

    @Autowired
    public MenuController(DataService<Client> clientService,
                          DataService<Tovar> tovarService,
                          DataService<Point> pointService,
                          DataService<Postavchik> postavchikService) {
        this.clientService = clientService;
        this.tovarService = tovarService;
        this.pointService = pointService;
        this.postavchikService = postavchikService;
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
}
