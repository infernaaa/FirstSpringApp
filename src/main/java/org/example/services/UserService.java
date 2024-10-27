package org.example.services;

import org.example.DataService;
import org.example.entity.Client;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements DataService<Client> {

    private final UserRepository UserRepository;


    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public List<Client> getAll() {
        return UserRepository.findAll();
    }
}
