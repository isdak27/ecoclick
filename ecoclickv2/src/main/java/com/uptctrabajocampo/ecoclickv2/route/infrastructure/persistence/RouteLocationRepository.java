package com.uptctrabajocampo.ecoclickv2.route.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import com.uptctrabajocampo.ecoclickv2.route.domain.RouteLocation;

public interface RouteLocationRepository extends JpaRepository<RouteLocation, Integer> {
    List<RouteLocation> findAllByLocation(Location location);
    List<RouteLocation> findAllByRoute(Route route);
    Optional<RouteLocation> findById(int routeLocationId);
}