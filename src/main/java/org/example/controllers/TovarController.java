package org.example.controllers;

import org.example.entity.Tovar;
import org.example.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tovar")
public class TovarController {

    private final DataService<Tovar> tovarService;

    @Autowired
    public TovarController(DataService<Tovar> tovarService) {
        this.tovarService = tovarService;
    }

    @GetMapping
    public String getTovars(Model model) {
        List<Tovar> tovars = tovarService.getAll();
        model.addAttribute("tovars", tovars);
        return "tovar_list";
    }
}
