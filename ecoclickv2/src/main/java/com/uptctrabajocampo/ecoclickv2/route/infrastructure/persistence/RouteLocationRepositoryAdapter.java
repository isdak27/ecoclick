package com.uptctrabajocampo.ecoclickv2.route.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.route.domain.RouteLocation;
import com.uptctrabajocampo.ecoclickv2.route.domain.RouteLocationPort;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;

@Component
public class RouteLocationRepositoryAdapter implements RouteLocationPort {

    private final RouteLocationRepository routeLocationRepository;

    public RouteLocationRepositoryAdapter(RouteLocationRepository routeLocationRepository) {
        this.routeLocationRepository = routeLocationRepository;
    }

    @Override
    public List<RouteLocation> getAllRoutesLocation() {
        return routeLocationRepository.findAll();
    }

    @Override
    public List<RouteLocation> getAllRoutesLocationByLocation(Location location) {
        return routeLocationRepository.findAllByLocation(location);
    }

    @Override
    public List<RouteLocation> getAllRoutesLocationByRoute(Route route) {
        return routeLocationRepository.findAllByRoute(route);
    }

    @Override
    public RouteLocation createRouteLocation(RouteLocation routeLocation) {
        return routeLocationRepository.save(routeLocation);
    }

    @Override
    public void updateRouteLocationRoute(int routeLocationId, Route route) {
        Optional<RouteLocation> optionalRouteLocation = routeLocationRepository.findById(routeLocationId);
        if (optionalRouteLocation.isPresent()) {
            RouteLocation routeLocation = optionalRouteLocation.get();
            routeLocation.setRoute(route);
            routeLocationRepository.save(routeLocation);
        } else {
            throw new ObjectNotFoundException("RouteLocation with id " + routeLocationId + " not found");
        }
    }

    @Override
    public void updateRouteLocationLocation(int routeLocationId, Location location) {
        Optional<RouteLocation> optionalRouteLocation = routeLocationRepository.findById(routeLocationId);
        if (optionalRouteLocation.isPresent()) {
            RouteLocation routeLocation = optionalRouteLocation.get();
            routeLocation.setLocation(location);
            routeLocationRepository.save(routeLocation);
        } else {
            throw new ObjectNotFoundException("RouteLocation with id " + routeLocationId + " not found");
        }
    }

    @Override
    public RouteLocation getRouteLocationById(int routeLocationId) {
        return routeLocationRepository.findById(routeLocationId).orElse(null);
    }
}