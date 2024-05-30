package com.uptctrabajocampo.ecoclickv2.drop.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.drop.domain.Stop;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;

public interface StopRepository extends JpaRepository<Stop, Integer> {
    List<Stop> findAllByExecutionDate(Date executionDate);
    List<Stop> findAllByStatus(String status);
    List<Stop> findAllByAssociatedJourney(Journey associatedJourney);
    List<Stop> findAllByAssociatedRequest(Request associatedRequest);
    Optional<Stop> findByRues(String rues);
}