package com.example.controller;

import com.example.model.Client;
import com.example.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    final
    ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/clients/{clientId}")
    public Client getClientById(@PathVariable("clientId") long clientId){
        return service.getClientById(clientId);

    }

    @PostMapping(path = "/clients", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Client createClient(@RequestBody Client newClient){
        return service.createClient(newClient);

    }

    @PutMapping("/clients/{clientId}")
    public Client editClientById(@RequestBody Client newClient,@PathVariable("clientId") long clientId){
        return service.editClient(clientId, newClient);
    }

    @DeleteMapping("/clients/{clientId}")
    public void deleteClientById(@PathVariable("clientId") long clientId){
        service.deleteClient(clientId);
    }


}