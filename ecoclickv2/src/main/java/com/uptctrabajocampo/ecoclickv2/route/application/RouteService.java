package com.uptctrabajocampo.ecoclickv2.route.application;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import com.uptctrabajocampo.ecoclickv2.route.domain.RoutePort;

@Service
public class RouteService implements RouteRestPort {

    private final RoutePort routePort;

    public RouteService(RoutePort routePort) {
        this.routePort = routePort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Route>>> getAllRoutes() {
        try {
            List<Route> routes = routePort.getAllRoutes();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), routes), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Route>>> getAllRoutesByOrganization(Organization organization) {
        if (organization == null || organization.getOrganizationId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Organization", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Route> routes = routePort.getAllRoutesByOrganization(organization);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), routes), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Route>>> getAllJourneyBystatus(String status) {
        if (status == null || status.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Status", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Route> routes = routePort.getAllJourneyByStatus(status);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), routes), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Route>> createRoute(Route route) {
        if (route == null || route.getRouteName() == null || route.getStatus() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route createdRoute = routePort.createRoute(route);
            return new ResponseEntity<>(new MessageRest<>(1, "Route Created", HttpStatus.CREATED.value(), createdRoute), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRoute(Route route) {
        if (route == null || route.getRouteId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route existingRoute = routePort.getRouteById(route.getRouteId());
            if (existingRoute != null) {
                routePort.updateRoute(route);
                return new ResponseEntity<>(new MessageRest<>(1, "Route Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Route Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateJourneyOrganization(int routeId, Organization organization) {
        if (routeId <= 0 || organization == null || organization.getOrganizationId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route existingRoute = routePort.getRouteById(routeId);
            if (existingRoute != null) {
                routePort.updateJourneyOrganization(routeId, organization);
                return new ResponseEntity<>(new MessageRest<>(1, "Route Organization Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Route Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateJourneyStatus(int routeId, String status) {
        if (routeId <= 0 || status == null || status.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route existingRoute = routePort.getRouteById(routeId);
            if (existingRoute != null) {
                routePort.updateJourneyStatus(routeId, status);
                return new ResponseEntity<>(new MessageRest<>(1, "Route Status Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Route Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateJourneyOrganizationIdentifier(int routeId, int organizationIdentifier) {
        if (routeId <= 0 || organizationIdentifier <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route existingRoute = routePort.getRouteById(routeId);
            if (existingRoute != null) {
                routePort.updateJourneyOrganizationIdentifier(routeId, organizationIdentifier);
                return new ResponseEntity<>(new MessageRest<>(1, "Route Organization Identifier Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Route Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateJourneyDescription(int routeId, String description) {
        if (routeId <= 0 || description == null || description.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route existingRoute = routePort.getRouteById(routeId);
            if (existingRoute != null) {
                routePort.updateJourneyDescription(routeId, description);
                return new ResponseEntity<>(new MessageRest<>(1, "Route Description Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Route Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Route>> getRouteyById(int routeId) {
        if (routeId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Route ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route route = routePort.getRouteById(routeId);
            if (route != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), route), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Route Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Route>> getRouteyByOrganizationIdentifier(int organizationIdentifier) {
        if (organizationIdentifier <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Organization Identifier", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route route = routePort.getRouteByOrganizationIdentifier(organizationIdentifier);
            if (route != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), route), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Route Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Route>> getRouteyByRouteName(String routeName) {
        if (routeName == null || routeName.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Route Name", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Route route = routePort.getRouteByRouteName(routeName);
            if (route != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), route), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Route Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}