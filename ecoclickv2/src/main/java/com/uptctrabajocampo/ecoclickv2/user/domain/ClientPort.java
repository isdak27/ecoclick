package com.uptctrabajocampo.ecoclickv2.user.domain;

import java.util.List;

public interface ClientPort {
  List<Client> getAllRecycler();
  void createClient(Client client);
  void updateClient(Client client);
  void updateClientEmail(int clientId,String email);
  void updateClientContactNumber(int clientId,String contactNumber);
  Client getClientById(int clientId);
  Client getClientByDocumentNumber(String documentNumber);
  Client getClientByemail(String email);
}
