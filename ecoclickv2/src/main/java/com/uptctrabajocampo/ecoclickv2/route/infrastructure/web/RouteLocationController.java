package com.uptctrabajocampo.ecoclickv2.route.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.route.application.RouteLocationService;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import com.uptctrabajocampo.ecoclickv2.route.domain.RouteLocation;

@RestController
@RequestMapping("/api/routeLocations")
public class RouteLocationController {

    @Autowired
    private final RouteLocationService routeLocationService;

    public RouteLocationController(RouteLocationService routeLocationService) {
        this.routeLocationService = routeLocationService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocation() {
        return routeLocationService.getAllRoutesLocation();
    }

    @GetMapping("/findByLocation")
    public ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocationByLocation(@RequestParam int locationId) {
        Location location = new Location();
        location.setLocationId(locationId);
        return routeLocationService.getAllRoutesLocationByLocation(location);
    }

    @GetMapping("/findByRoute")
    public ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocationByRoute(@RequestParam int routeId) {
        Route route = new Route();
        route.setRouteId(routeId);
        return routeLocationService.getAllRoutesLocationByRoute(route);
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<RouteLocation>> createRouteLocation(@RequestBody RouteLocation routeLocation) {
        return routeLocationService.createRouteLocation(routeLocation);
    }

    @PutMapping("/updateRoute")
    public ResponseEntity<MessageRest<Void>> updateRouteLocationRoute(@RequestParam int routeLocationId, @RequestParam int routeId) {
        Route route = new Route();
        route.setRouteId(routeId);
        return routeLocationService.UpdateRouteLocationRoute(routeLocationId, route);
    }

    @PutMapping("/updateLocation")
    public ResponseEntity<MessageRest<Void>> updateRouteLocationLocation(@RequestParam int routeLocationId, @RequestParam int locationId) {
        Location location = new Location();
        location.setLocationId(locationId);
        return routeLocationService.UpdateRouteLocationLocation(routeLocationId, location);
    }

    @GetMapping("/findById")
    public ResponseEntity<MessageRest<RouteLocation>> getRouteLocationById(@RequestParam int routeLocationId) {
        return routeLocationService.getRouteyLocationById(routeLocationId);
    }
}
