package org.example.controllers;

import org.example.entity.Postavchik;
import org.example.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/postavchik")
public class PostavchikController {

    private final DataService<Postavchik> postavchikService;

    @Autowired
    public PostavchikController(DataService<Postavchik> postavchikService) {
        this.postavchikService = postavchikService;
    }

    @GetMapping
    public String getPostavchiks(Model model) {
        List<Postavchik> postavchiks = postavchikService.getAll();
        model.addAttribute("postavchiks", postavchiks);
        return "postavchik_list";
    }
}
