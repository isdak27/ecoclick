package com.uptctrabajocampo.ecoclickv2.drop.domain;

import java.util.Date;
import java.util.List;

import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;


public interface StopPort {
  List<Stop> getAllStop();
  List<Stop> getAllStopByDate(Date executionDate);
  List<Stop> getAllStopByStatus(String status);
  List<Stop> getAllStopByAssociatedJourney(Journey associatedJourney);
  List<Stop> getAllStopByAssociatedRequest(Request associatedRequest);
  Stop createStop(Stop stop);
  void updateStop(Stop stop);
  void updateStopStatus(int stopId,String status);
  void updateStopRating(int stopId,int rating);
  void updateStopDetails(int stopId,String stopDetails);
}
