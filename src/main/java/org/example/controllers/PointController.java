package org.example.controllers;

import org.example.entity.Point;
import org.example.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/point")
public class PointController {

    private final DataService<Point> pointService;

    @Autowired
    public PointController(DataService<Point> pointService) {
        this.pointService = pointService;
    }

    @GetMapping
    public String getPoints(Model model) {
        List<Point> points = pointService.getAll();
        model.addAttribute("points", points);
        return "point_list";
    }
}
