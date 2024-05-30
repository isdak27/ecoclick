package com.uptctrabajocampo.ecoclickv2.recycler.application;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;

public interface RecyclerRestPort {
  ResponseEntity<MessageRest<List<Recycler>>> getAllRecycler();
  ResponseEntity<MessageRest<Recycler>> createRecycler(Recycler recycler);
  ResponseEntity<MessageRest<Recycler>> createRecycler(String firstName, String lastName, 
    String documentType, String documentNumber, Date dateOfBirth, String contactNumber, 
    String alternativeNumber, String email, String alternativeEmail);
  ResponseEntity<MessageRest<Recycler>> createRecycler(String environmentalLicense,String firstName, String lastName, 
    String documentType, String documentNumber, Date dateOfBirth, String contactNumber, 
    String alternativeNumber, String email, String alternativeEmail);
  ResponseEntity<MessageRest<Void>> updateRecycler(Recycler recycler);
  ResponseEntity<MessageRest<Void>> updateRecyclerEnvironmentalLicense(int recyclerId,String environmentalLicense);
  ResponseEntity<MessageRest<Void>> updateRecyclerEmail(int recyclerId,String email);
  ResponseEntity<MessageRest<Void>> updateRecyclerContactNumber(int recyclerId,String contactNumber);
  ResponseEntity<MessageRest<Void>> updateRecyclerAlternativeNumber(int recyclerId,String alternativeNumber);
  ResponseEntity<MessageRest<Void>> updateRecyclerAlternativeEmail(int recyclerId,String alternativeEmail);
  ResponseEntity<MessageRest<Recycler>> getRecyclerByEnvironmentalLicense(String environmentalLicense);
  ResponseEntity<MessageRest<Recycler>> getRecyclerById(int recyclerId);
  ResponseEntity<MessageRest<Recycler>> getRecyclerByDocumentNumber(String documentNumber);
  ResponseEntity<MessageRest<Recycler>> getRecyclerByemail(String email);
}
