package com.uptctrabajocampo.ecoclickv2.user.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;
import com.uptctrabajocampo.ecoclickv2.user.domain.ClientPort;

@Service
public class ClientService implements ClientRestPort {

    @Autowired
    private final ClientPort clientPort;

    public ClientService(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Client>>> getAllRecycler() {
        try {
            List<Client> clients = clientPort.getAllRecycler();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), clients), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Client>> createClient(Client client) {
        if (client == null || client.getDocumentNumber() == null || client.getEmail() == null || client.getClientId() != 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            clientPort.createClient(client);
            return new ResponseEntity<>(new MessageRest<>(1, "Client Created", HttpStatus.CREATED.value(), client), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Client>> createClient(String firstName, String lastName, String documentType, String documentNumber, Date dateOfBirth, String email, String phone) {
        Client client = new Client(firstName, lastName, documentType, documentNumber, dateOfBirth, email, phone);
        return createClient(client);
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateClient(Client client) {
        if (client == null || client.getClientId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Client existingClient = clientPort.getClientById(client.getClientId());
            if (existingClient != null) {
                clientPort.updateClient(client);
                return new ResponseEntity<>(new MessageRest<>(1, "Client Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Client Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateClientEmail(int clientId, String email) {
        try {
            Client existingClient = clientPort.getClientById(clientId);
            if (existingClient != null) {
                clientPort.updateClientEmail(clientId, email);
                return new ResponseEntity<>(new MessageRest<>(1, "Client Email Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Client Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateClientContactNumber(int clientId, String contactNumber) {
        try {
            Client existingClient = clientPort.getClientById(clientId);
            if (existingClient != null) {
                clientPort.updateClientContactNumber(clientId, contactNumber);
                return new ResponseEntity<>(new MessageRest<>(1, "Client Contact Number Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Client Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Client>> getClientById(int clientId) {
        if (clientId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Client ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Client client = clientPort.getClientById(clientId);
            if (client != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), client), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Client Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Client>> getClientByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Document Number", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Client client = clientPort.getClientByDocumentNumber(documentNumber);
            if (client != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), client), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Client Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Client>> getClientByemail(String email) {
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Email", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Client client = clientPort.getClientByemail(email);
            if (client != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), client), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Client Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}