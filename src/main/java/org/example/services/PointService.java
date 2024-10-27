package org.example.services;


import org.example.DataService;
import org.example.entity.Point;
import org.example.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService implements DataService<Point> {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Override
    public List<Point> getAll() {
        return pointRepository.findAll();
    }
}
