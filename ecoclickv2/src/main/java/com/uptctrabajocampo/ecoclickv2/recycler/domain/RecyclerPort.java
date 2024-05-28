package com.uptctrabajocampo.ecoclickv2.recycler.domain;

import java.util.List;

public interface RecyclerPort {
  List<Recycler> getAllRecycler();
  void createRecycler(Recycler recycler);
  void updateRecycler(Recycler recycler);
  void updateRecyclerEnvironmentalLicense(int recyclerId,String environmentalLicense);
  void updateRecyclerEmail(int recyclerId,String email);
  void updateRecyclerContactNumber(int recyclerId,String contactNumber);
  void updateRecyclerAlternativeNumber(int recyclerId,String alternativeNumber);
  void updateRecyclerAlternativeEmail(int recyclerId,String alternativeEmail);
  Recycler getRecyclerByEnvironmentalLicense(String environmentalLicense);
  Recycler getRecyclerById(int recyclerId);
  Recycler getRecyclerByDocumentNumber(String documentNumber);
  Recycler getRecyclerByemail(String email);
}
