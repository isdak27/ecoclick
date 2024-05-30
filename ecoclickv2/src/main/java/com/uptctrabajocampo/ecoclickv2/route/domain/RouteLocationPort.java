package com.uptctrabajocampo.ecoclickv2.route.domain;

import java.util.List;

import com.uptctrabajocampo.ecoclickv2.location.domain.Location;

public interface RouteLocationPort {
    List<RouteLocation> getAllRoutesLocation();
    List<RouteLocation> getAllRoutesLocationByLocation(Location location);
    List<RouteLocation> getAllRoutesLocationByRoute(Route route);
    RouteLocation createRouteLocation(RouteLocation routeLocation);
    void updateRouteLocationRoute(int routeLocationId, Route route);
    void updateRouteLocationLocation(int routeLocationId, Location location);
    RouteLocation getRouteLocationById(int routeLocationId);
}
