package com.uptctrabajocampo.ecoclickv2.drop.application;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.drop.domain.Stop;
import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;

public interface StopRestPort {
  ResponseEntity<MessageRest<List<Stop>>> getAllStop();
  ResponseEntity<MessageRest<List<Stop>>> getAllStopByDate(Date executionDate);
  ResponseEntity<MessageRest<List<Stop>>> getAllStopByStatus(String status);
  ResponseEntity<MessageRest<List<Stop>>> getAllStopByAssociatedJourney(Journey associatedJourney);
  ResponseEntity<MessageRest<List<Stop>>> getAllStopByAssociatedJourney(Request associatedRequest);
  ResponseEntity<MessageRest<Stop>> createStop(Stop stop);
  ResponseEntity<MessageRest<Void>> updateStop(Stop stop);
  ResponseEntity<MessageRest<Void>> updateStopStatus(int stopId,String status);
  ResponseEntity<MessageRest<Void>> updateStopRating(int stopId,int rating);
  ResponseEntity<MessageRest<Void>> updateStopDetails(int stopId,String stopDetails);
  ResponseEntity<MessageRest<Stop>> getOrganizationRues(String rues);
  ResponseEntity<MessageRest<Stop>> getOrganizationById(int stopId);
}
