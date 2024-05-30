package com.uptctrabajocampo.ecoclickv2.route.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import com.uptctrabajocampo.ecoclickv2.route.domain.RouteLocation;
import com.uptctrabajocampo.ecoclickv2.route.domain.RouteLocationPort;

@Service
public class RouteLocationService implements RouteLocationRestPort {

    @Autowired
    private final RouteLocationPort routeLocationPort;

    public RouteLocationService(RouteLocationPort routeLocationPort) {
        this.routeLocationPort = routeLocationPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocation() {
        try {
            List<RouteLocation> routeLocations = routeLocationPort.getAllRoutesLocation();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), routeLocations), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocationByLocation(Location location) {
        if (location == null || location.getLocationId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Location", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<RouteLocation> routeLocations = routeLocationPort.getAllRoutesLocationByLocation(location);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), routeLocations), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<RouteLocation>>> getAllRoutesLocationByRoute(Route route) {
        if (route == null || route.getRouteId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Route", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<RouteLocation> routeLocations = routeLocationPort.getAllRoutesLocationByRoute(route);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), routeLocations), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<RouteLocation>> createRouteLocation(RouteLocation routeLocation) {
        if (routeLocation == null || routeLocation.getRoute() == null || routeLocation.getLocation() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            routeLocationPort.createRouteLocation(routeLocation);
            return new ResponseEntity<>(new MessageRest<>(1, "RouteLocation Created", HttpStatus.CREATED.value(), routeLocation), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> UpdateRouteLocationRoute(int routeLocationId, Route route) {
        if (routeLocationId <= 0 || route == null || route.getRouteId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            RouteLocation existingRouteLocation = routeLocationPort.getRouteLocationById(routeLocationId);
            if (existingRouteLocation != null) {
                routeLocationPort.updateRouteLocationRoute(routeLocationId, route);
                return new ResponseEntity<>(new MessageRest<>(1, "RouteLocation Route Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "RouteLocation Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> UpdateRouteLocationLocation(int routeLocationId, Location location) {
        if (routeLocationId <= 0 || location == null || location.getLocationId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            RouteLocation existingRouteLocation = routeLocationPort.getRouteLocationById(routeLocationId);
            if (existingRouteLocation != null) {
                routeLocationPort.updateRouteLocationLocation(routeLocationId, location);
                return new ResponseEntity<>(new MessageRest<>(1, "RouteLocation Location Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "RouteLocation Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<RouteLocation>> getRouteyLocationById(int routeLocationId) {
        if (routeLocationId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid RouteLocation ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            RouteLocation routeLocation = routeLocationPort.getRouteLocationById(routeLocationId);
            if (routeLocation != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), routeLocation), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "RouteLocation Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}