package com.uptctrabajocampo.ecoclickv2.route.infrastructure.web;


import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;
import com.uptctrabajocampo.ecoclickv2.route.application.RouteService;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Route>>> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/findByOrganization")
    public ResponseEntity<MessageRest<List<Route>>> getAllRoutesByOrganization(@RequestParam Organization organization) {
        return routeService.getAllRoutesByOrganization(organization);
    }

    @GetMapping("/findByStatus")
    public ResponseEntity<MessageRest<List<Route>>> getAllJourneyByStatus(@RequestParam String status) {
        return routeService.getAllJourneyBystatus(status);
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Route>> createRoute(@RequestBody Route route) {
        return routeService.createRoute(route);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateRoute(@RequestBody Route route) {
        return routeService.updateRoute(route);
    }

    @PatchMapping("/update/organization")
    public ResponseEntity<MessageRest<Void>> updateJourneyOrganization(@RequestParam int routeId, @RequestParam Organization organization) {
        return routeService.updateJourneyOrganization(routeId, organization);
    }

    @PatchMapping("/update/status")
    public ResponseEntity<MessageRest<Void>> updateJourneyStatus(@RequestParam int routeId, @RequestParam String status) {
        return routeService.updateJourneyStatus(routeId, status);
    }

    @PatchMapping("/update/organizationIdentifier")
    public ResponseEntity<MessageRest<Void>> updateJourneyOrganizationIdentifier(@RequestParam int routeId, @RequestParam int organizationIdentifier) {
        return routeService.updateJourneyOrganizationIdentifier(routeId, organizationIdentifier);
    }

    @PatchMapping("/update/description")
    public ResponseEntity<MessageRest<Void>> updateJourneyDescription(@RequestParam int routeId, @RequestParam String description) {
        return routeService.updateJourneyDescription(routeId, description);
    }

    @GetMapping("/findById")
    public ResponseEntity<MessageRest<Route>> getRouteById(@RequestParam int routeId) {
        return routeService.getRouteyById(routeId);
    }

    @GetMapping("/findByOrganizationIdentifier")
    public ResponseEntity<MessageRest<Route>> getRouteByOrganizationIdentifier(@RequestParam int organizationIdentifier) {
        return routeService.getRouteyByOrganizationIdentifier(organizationIdentifier);
    }

    @GetMapping("/findByRouteName")
    public ResponseEntity<MessageRest<Route>> getRouteByRouteName(@RequestParam String routeName) {
        return routeService.getRouteyByRouteName(routeName);
    }
}