package com.uptctrabajocampo.ecoclickv2.route.domain;

import java.util.Date;
import java.util.List;

public interface JourneyPort {
  List<Journey> getAllJourneys();
  List<Journey> getAllJourneyByAssignedRoute(Route assignedRoute);
  List<Journey> getAllJourneyByDate(Date executionDate);
  void createJourney(Journey journey);
  void updateJourney(Journey journey);
  void updateJourneyAssignedRoute(int journeyId , Route assignedRoute);
  void updateJourneyExecutionDate(int journeyId,Date executionDate);
  void updateJourneyDetails(int journeyId,String journeyDetails);
  Journey getJourneyById(int journeyId);
}
