package org.example.services;

import org.example.DataService;
import org.example.entity.Client;
import org.example.entity.Zakazano;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public Integer calculateTotalPurchases(Long clientId) {
        return UserRepository.calculateTotalPurchasesByClientId(clientId);
    }
    public List <Object[]> calculateTotalOrdersClient(Long clientId) {
        return UserRepository.findOrderSumsByClientId(clientId);
    }
    public Client getClientById(Long clientId) {
        return UserRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }
    public void saveClient(Client client) {
        UserRepository.save(client);
    }

    public void updateClient(Client client) {
        UserRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        UserRepository.deleteById(clientId);
    }

}
