package org.example.services;

import org.example.DataService;
import org.example.entity.Tovar;
import org.example.repositories.TovarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TovarService implements DataService<Tovar> {

    private final TovarRepository tovarRepository;

    @Autowired
    public TovarService(TovarRepository tovarRepository) {
        this.tovarRepository = tovarRepository;
    }

    @Override
    public List<Tovar> getAll() {
        return tovarRepository.findAll();
    }
}
