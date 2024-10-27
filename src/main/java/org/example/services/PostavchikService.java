package org.example.services;

import org.example.DataService;
import org.example.entity.Postavchik;
import org.example.repositories.PostavchikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostavchikService implements DataService<Postavchik> {

    private final PostavchikRepository postavchikRepository;

    @Autowired
    public PostavchikService(PostavchikRepository postavchikRepository) {
        this.postavchikRepository = postavchikRepository;
    }

    @Override
    public List<Postavchik> getAll() {
        return postavchikRepository.findAll();
    }
}
