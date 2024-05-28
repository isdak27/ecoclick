package com.uptctrabajocampo.ecoclickv2.recycler.application;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;

public interface RecyclerRestPort {
  ResponseEntity<List<Recycler>> getAllRecycler();
  ResponseEntity<Void> createRecycler(Recycler recycler);
  ResponseEntity<Void> createRecycler(String firstName, String lastName, 
    String documentType, String documentNumber, Date dateOfBirth, String contactNumber, 
    String alternativeNumber, String email, String alternativeEmail);
  ResponseEntity<Void> createRecycler(String environmentalLicense,String firstName, String lastName, 
    String documentType, String documentNumber, Date dateOfBirth, String contactNumber, 
    String alternativeNumber, String email, String alternativeEmail);
  ResponseEntity<Void> updateRecycler(Recycler recycler);
  ResponseEntity<Void> updateRecyclerEnvironmentalLicense(int recyclerId,String environmentalLicense);
  ResponseEntity<Void> updateRecyclerEmail(int recyclerId,String email);
  ResponseEntity<Void> updateRecyclerContactNumber(int recyclerId,String contactNumber);
  ResponseEntity<Void> updateRecyclerAlternativeNumber(int recyclerId,String alternativeNumber);
  ResponseEntity<Void> updateRecyclerAlternativeEmail(int recyclerId,String alternativeEmail);
  ResponseEntity<Recycler> getRecyclerByEnvironmentalLicense(String environmentalLicense);
  ResponseEntity<Recycler> getRecyclerById(int recyclerId);
  ResponseEntity<Recycler> getRecyclerByDocumentNumber(String documentNumber);
  ResponseEntity<Recycler> getRecyclerByemail(String email);
}
