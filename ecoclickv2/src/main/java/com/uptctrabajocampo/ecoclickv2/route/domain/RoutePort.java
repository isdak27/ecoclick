package com.uptctrabajocampo.ecoclickv2.route.domain;

import java.util.List;

import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;

public interface RoutePort {
  List<Route> getAllRoutes();
  List<Route> getAllRoutesByOrganization(Organization organization);
  List<Route> getAllJourneyByStatus(String status);
  Route createRoute(Route route);
  void updateRoute(Route route);
  void updateJourneyOrganization(int routeId , Organization organization);
  void updateJourneyStatus(int routeId , String status);
  void updateJourneyOrganizationIdentifier(int routeId,int organizationIdentifier);
  void updateJourneyDescription(int routeId,String description);
  Route getRouteById(int routeId);
  Route getRouteByOrganizationIdentifier(int organizationIdentifier);
  Route getRouteByRouteName(String routeName);
}
