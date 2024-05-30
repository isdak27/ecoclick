package com.uptctrabajocampo.ecoclickv2.request.domain;

import java.util.Date;
import java.util.List;

import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;

public interface RequestPort {
  List<Request> getAllRequest();
  List<Request> getAllRequestByRequestingClient(Client requestingClient);
  List<Request> getAllRequestByLocation(Location location);
  List<Request> getAllRequestByRequestDate(Date requestDate);
  Request createRequest(Request request);
  void updateRequest(Request request);
  void updateRequestRequestingClient(int requestId,Client requestingClient);
  void updateRequestLocation(int requestId,Location location);
  void updateRequestRequestDate(int requestId,Date requestDate);
  void updateRequestStatus(int requestId,String status);
  void updateRequestImageReference(int requestId,String imageReference);
  void updateRequestDetails(int requestId,String details);
  Request getRequestById(int requestId);
}
