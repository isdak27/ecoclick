package com.uptctrabajocampo.ecoclickv2.route.application;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;

public interface JourneyRestPort {
  ResponseEntity<MessageRest<List<Journey>>> getAllJourneyS();
  ResponseEntity<MessageRest<List<Journey>>> getAllJourneyByassignedRoute(Route assignedRoute);
  ResponseEntity<MessageRest<List<Journey>>> getAllJourneyByDate(Date executionDate);
  ResponseEntity<MessageRest<Journey>> createJourney(Journey journey);
  ResponseEntity<MessageRest<Void>> updateJourney(Journey journey);
  ResponseEntity<MessageRest<Void>> updateJourneyAssignedRoute(int journeyId , Route assignedRoute);
  ResponseEntity<MessageRest<Void>> updateJourneyExecutionDate(int journeyId,Date executionDate);
  ResponseEntity<MessageRest<Void>> updateJourneyDetails(int journeyId,String journeyDetails);
  ResponseEntity<MessageRest<Journey>> getJourneyById(int journeyId);
}
