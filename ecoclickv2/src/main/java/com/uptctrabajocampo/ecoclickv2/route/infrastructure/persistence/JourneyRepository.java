package com.uptctrabajocampo.ecoclickv2.route.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;

public interface JourneyRepository extends JpaRepository<Journey, Integer> {
    List<Journey> findAllByAssignedRoute(Route assignedRoute);
    List<Journey> findAllByExecutionDate(Date executionDate);
    Optional<Journey> findById(int journeyId);
}