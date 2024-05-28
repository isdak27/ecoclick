package com.uptctrabajocampo.ecoclickv2.user.infrastructure.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.user.application.ClientService;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;

@Controller
@RestController
@RequestMapping("/api/clients")
public class ClientController {
    
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Client>>> getAllClients() {
        return clientService.getAllRecycler();
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Client>> createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PostMapping("/create/allParams")
    public  ResponseEntity<MessageRest<Client>> createClient(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String documentType,
            @RequestParam String documentNumber,
            @RequestParam Date dateOfBirth,
            @RequestParam String email,
            @RequestParam String phone) {
        return clientService.createClient(firstName, lastName, documentType, documentNumber, dateOfBirth, email, phone);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @PatchMapping("/update/email")
    public  ResponseEntity<MessageRest<Void>> updateClientEmail(@RequestParam int clientId, @RequestParam String email) {
        return clientService.updateClientEmail(clientId, email);
    }

    @PatchMapping("/update/contactNumber")
    public  ResponseEntity<MessageRest<Void>> updateClientContactNumber(@RequestParam int clientId, @RequestParam String contactNumber) {
        return clientService.updateClientContactNumber(clientId, contactNumber);
    }

    @GetMapping("/findById")
    public ResponseEntity<MessageRest<Client>> getClientById(@RequestParam int clientId) {
        return clientService.getClientById(clientId);
    }

    @GetMapping("/findByDocumentNumber")
    public ResponseEntity<MessageRest<Client>> getClientByDocumentNumber(@RequestParam String documentNumber) {
        return clientService.getClientByDocumentNumber(documentNumber);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<MessageRest<Client>> getClientByEmail(@RequestParam String email) {
        return clientService.getClientByemail(email);
    }
}
