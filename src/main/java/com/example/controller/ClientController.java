package com.example.controller;

import com.example.model.Client;
import com.example.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    final
    ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/client/{clientId}")
    public Client getPlayerById(@PathVariable("clientId") long clientId){
        return service.getClientById(clientId);

    }


}