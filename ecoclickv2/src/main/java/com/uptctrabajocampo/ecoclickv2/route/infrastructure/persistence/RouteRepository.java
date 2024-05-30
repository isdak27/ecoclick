package com.uptctrabajocampo.ecoclickv2.route.infrastructure.persistence;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.route.domain.Route;
import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    Optional<Route> findByRouteName(String routeName);
    Optional<Route> findByOrganizationIdentifier(int organizationIdentifier);
    List<Route> findAllByOrganization(Organization organization);
    List<Route> findAllByStatus(String status);
}