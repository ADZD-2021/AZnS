package com.example.service;

import com.example.model.Client;
import com.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ClientService {

    final
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    public Client getClientById(long clientId) {
        Client client = clientRepository.findById(clientId);
        return client;
    }

    @PostConstruct
    public void InitializeClients(){

        Client client1 = new Client("Jan", "Kowalski", "Sadowa 7, 42-202, Katowice", "321312051");
        Client client2 = new Client("Dariusz", "Malinowski", "Wojskowa 14, 41-203, Gliwice", "2131235612");
        clientRepository.save(client1);
        clientRepository.save(client2);

    }



}
