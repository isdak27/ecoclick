package com.uptctrabajocampo.ecoclickv2.route.application;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import com.uptctrabajocampo.ecoclickv2.route.domain.RouteLocation;

public interface RouteLocationPort {
    ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocation();
    ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocationByLocation(Location location);
    ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocationByRoute(Route route);
    ResponseEntity<MessageRest<RouteLocation>> createRouteLocation(RouteLocation routeLocation);
    ResponseEntity<MessageRest<Void>> UpdateRouteLocationRoute(int routeLocationId, Route route);
    ResponseEntity<MessageRest<Void>> UpdateRouteLocationLocation(int routeLocationId, Location location);
    ResponseEntity<MessageRest<RouteLocation>> getRouteyLocationById(int routeLocationId);
}
