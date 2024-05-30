package com.uptctrabajocampo.ecoclickv2.request.application;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;

public interface RequestRestPort {
  ResponseEntity<MessageRest<List<Request>>> getAllRequest();
  ResponseEntity<MessageRest<List<Request>>> getAllRequestByRequestingClient(Client requestingClient);
  ResponseEntity<MessageRest<List<Request>>> getAllRequestByLocation(Location location);
  ResponseEntity<MessageRest<List<Request>>> getAllRequestByRequestDate(Date requestDate);
  ResponseEntity<MessageRest<Request>> createRequest(Request request);
  ResponseEntity<MessageRest<Void>> updateRequest(Request request);
  ResponseEntity<MessageRest<Void>> updateRequestRequestingClient(int requestId,Client requestingClient);
  ResponseEntity<MessageRest<Void>> updateRequestLocation(int requestId,Location location);
  ResponseEntity<MessageRest<Void>> updateRequestRequestDate(int requestId,Date requestDate);
  ResponseEntity<MessageRest<Void>> updateRequestStatus(int requestId,String status);
  ResponseEntity<MessageRest<Void>> updateRequestImageReference(int requestId,String imageReference);
  ResponseEntity<MessageRest<Void>> updateRequestDetails(int requestId,String details);
  ResponseEntity<MessageRest<Request>> getRequestById(int requestId);
}
