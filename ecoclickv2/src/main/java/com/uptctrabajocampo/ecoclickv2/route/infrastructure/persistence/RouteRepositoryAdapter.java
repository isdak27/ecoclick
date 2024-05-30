package com.uptctrabajocampo.ecoclickv2.route.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import com.uptctrabajocampo.ecoclickv2.route.domain.RoutePort;
import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;
import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;

@Component
public class RouteRepositoryAdapter implements RoutePort {

    private final RouteRepository routeRepository;

    public RouteRepositoryAdapter(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public List<Route> getAllRoutesByOrganization(Organization organization) {
        return routeRepository.findAllByOrganization(organization);
    }

    @Override
    public List<Route> getAllJourneyByStatus(String status) {
        return routeRepository.findAllByStatus(status);
    }

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public void updateRoute(Route route) {
        if (routeRepository.existsById(route.getRouteId())) {
            routeRepository.save(route);
        } else {
            throw new ObjectNotFoundException("Route with id " + route.getRouteId() + " not found");
        }
    }

    @Override
    public void updateJourneyOrganization(int routeId, Organization organization) {
        Optional<Route> optionalRoute = routeRepository.findById(routeId);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setOrganization(organization);
            routeRepository.save(route);
        } else {
            throw new ObjectNotFoundException("Route with id " + routeId + " not found");
        }
    }

    @Override
    public void updateJourneyStatus(int routeId, String status) {
        Optional<Route> optionalRoute = routeRepository.findById(routeId);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setStatus(status);
            routeRepository.save(route);
        } else {
            throw new ObjectNotFoundException("Route with id " + routeId + " not found");
        }
    }

    @Override
    public void updateJourneyOrganizationIdentifier(int routeId, int organizationIdentifier) {
        Optional<Route> optionalRoute = routeRepository.findById(routeId);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setOrganizationIdentifier(organizationIdentifier);
            routeRepository.save(route);
        } else {
            throw new ObjectNotFoundException("Route with id " + routeId + " not found");
        }
    }

    @Override
    public void updateJourneyDescription(int routeId, String description) {
        Optional<Route> optionalRoute = routeRepository.findById(routeId);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setDescription(description);
            routeRepository.save(route);
        } else {
            throw new ObjectNotFoundException("Route with id " + routeId + " not found");
        }
    }

    @Override
    public Route getRouteById(int routeId) {
        return routeRepository.findById(routeId).orElse(null);
    }

    @Override
    public Route getRouteByOrganizationIdentifier(int organizationIdentifier) {
        return routeRepository.findByOrganizationIdentifier(organizationIdentifier).orElse(null);
    }

    @Override
    public Route getRouteByRouteName(String routeName) {
        return routeRepository.findByRouteName(routeName).orElse(null);
    }
}
