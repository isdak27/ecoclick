package com.uptctrabajocampo.ecoclickv2.route.application;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;

public interface RouteRestPort {
  ResponseEntity<MessageRest<List<Route>>> getAllRoutes();
  ResponseEntity<MessageRest<List<Route>>> getAllRoutesByOrganization(Organization organization);
  ResponseEntity<MessageRest<List<Route>>> getAllJourneyBystatus(String status);
  ResponseEntity<MessageRest<Route>> createRoute(Route route);
  ResponseEntity<MessageRest<Void>> updateRoute(Route route);
  ResponseEntity<MessageRest<Void>> updateJourneyOrganization(int routeId , Organization organization);
  ResponseEntity<MessageRest<Void>> updateJourneyStatus(int routeId , String status);
  ResponseEntity<MessageRest<Void>> updateJourneyOrganizationIdentifier(int routeId,int organizationIdentifier);
  ResponseEntity<MessageRest<Void>> updateJourneyDescription(int routeId,String description);
  ResponseEntity<MessageRest<Route>> getRouteyById(int routeId);
  ResponseEntity<MessageRest<Route>> getRouteyByOrganizationIdentifier(int organizationIdentifier);
  ResponseEntity<MessageRest<Route>> getRouteyByRouteName(String routeName);
}