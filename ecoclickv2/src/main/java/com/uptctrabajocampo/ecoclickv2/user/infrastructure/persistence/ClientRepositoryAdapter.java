package com.uptctrabajocampo.ecoclickv2.user.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;
import com.uptctrabajocampo.ecoclickv2.user.domain.ClientPort;

@Component
public class ClientRepositoryAdapter implements ClientPort{
    @Autowired
    private final ClientRepository clientRepository;

    public ClientRepositoryAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllRecycler() {
        return clientRepository.findAll();
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Client client) {
        if (clientRepository.existsById(client.getClientId())) {
            clientRepository.save(client);
        } else {
            throw new ObjectNotFoundException("Client with id " + client.getClientId() + " not found");
        }
    }

    @Override
    public void updateClientEmail(int clientId, String email) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setEmail(email);
            clientRepository.save(client);
        } else {
            throw new ObjectNotFoundException("Client with id " + clientId + " not found");
        }
    }

    @Override
    public void updateClientContactNumber(int clientId, String contactNumber) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setPhone(contactNumber);
            clientRepository.save(client);
        } else {
            throw new ObjectNotFoundException("Client with id " + clientId + " not found");
        }
    }

    @Override
    public Client getClientById(int clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    @Override
    public Client getClientByDocumentNumber(String documentNumber) {
        return clientRepository.findByDocumentNumber(documentNumber).orElse(null);
    }

    @Override
    public Client getClientByemail(String email) {
        return clientRepository.findByEmail(email).orElse(null);
    }
}
