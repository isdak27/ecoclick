package com.uptctrabajocampo.ecoclickv2.user.application;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;



public interface ClientRestPort {

  ResponseEntity<MessageRest<List<Client>>> getAllRecycler();
  ResponseEntity<MessageRest<Client>> createClient(Client client);
  ResponseEntity<MessageRest<Client>> createClient(String firstName, String lastName, String documentType, String documentNumber,
  Date dateOfBirth, String email, String phone);
  ResponseEntity<MessageRest<Void>> updateClient(Client client);
  ResponseEntity<MessageRest<Void>> updateClientEmail(int clientId,String email);
  ResponseEntity<MessageRest<Void>> updateClientContactNumber(int clientId,String contactNumber);
  ResponseEntity<MessageRest<Client>> getClientById(int clientId);
  ResponseEntity<MessageRest<Client>> getClientByDocumentNumber(String documentNumber);
  ResponseEntity<MessageRest<Client>> getClientByemail(String email);
}
