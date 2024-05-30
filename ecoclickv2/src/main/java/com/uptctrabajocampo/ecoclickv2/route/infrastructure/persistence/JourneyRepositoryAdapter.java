package com.uptctrabajocampo.ecoclickv2.route.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;
import com.uptctrabajocampo.ecoclickv2.route.domain.JourneyPort;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;

@Component
public class JourneyRepositoryAdapter implements JourneyPort {

    private final JourneyRepository journeyRepository;

    public JourneyRepositoryAdapter(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    @Override
    public List<Journey> getAllJourneys() {
        return journeyRepository.findAll();
    }

    @Override
    public List<Journey> getAllJourneyByAssignedRoute(Route assignedRoute) {
        return journeyRepository.findAllByAssignedRoute(assignedRoute);
    }

    @Override
    public List<Journey> getAllJourneyByDate(Date executionDate) {
        return journeyRepository.findAllByExecutionDate(executionDate);
    }

    @Override
    public void createJourney(Journey journey) {
        journeyRepository.save(journey);
    }

    @Override
    public void updateJourney(Journey journey) {
        if (journeyRepository.existsById(journey.getJourneyId())) {
            journeyRepository.save(journey);
        } else {
            throw new ObjectNotFoundException("Journey with id " + journey.getJourneyId() + " not found");
        }
    }

    @Override
    public void updateJourneyAssignedRoute(int journeyId, Route assignedRoute) {
        Optional<Journey> optionalJourney = journeyRepository.findById(journeyId);
        if (optionalJourney.isPresent()) {
            Journey journey = optionalJourney.get();
            journey.setAssignedRoute(assignedRoute);
            journeyRepository.save(journey);
        } else {
            throw new ObjectNotFoundException("Journey with id " + journeyId + " not found");
        }
    }

    @Override
    public void updateJourneyExecutionDate(int journeyId, Date executionDate) {
        Optional<Journey> optionalJourney = journeyRepository.findById(journeyId);
        if (optionalJourney.isPresent()) {
            Journey journey = optionalJourney.get();
            journey.setExecutionDate(executionDate);
            journeyRepository.save(journey);
        } else {
            throw new ObjectNotFoundException("Journey with id " + journeyId + " not found");
        }
    }

    @Override
    public void updateJourneyDetails(int journeyId, String journeyDetails) {
        Optional<Journey> optionalJourney = journeyRepository.findById(journeyId);
        if (optionalJourney.isPresent()) {
            Journey journey = optionalJourney.get();
            journey.setJourneyDetails(journeyDetails);
            journeyRepository.save(journey);
        } else {
            throw new ObjectNotFoundException("Journey with id " + journeyId + " not found");
        }
    }

    @Override
    public Journey getJourneyById(int journeyId) {
        return journeyRepository.findById(journeyId).orElse(null);
    }
}