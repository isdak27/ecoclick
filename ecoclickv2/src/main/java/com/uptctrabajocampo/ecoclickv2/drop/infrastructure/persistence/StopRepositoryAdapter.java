package com.uptctrabajocampo.ecoclickv2.drop.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.drop.domain.Stop;
import com.uptctrabajocampo.ecoclickv2.drop.domain.StopPort;
import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;

@Component
public class StopRepositoryAdapter implements StopPort {

    private final StopRepository stopRepository;

    public StopRepositoryAdapter(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @Override
    public List<Stop> getAllStop() {
        return stopRepository.findAll();
    }

    @Override
    public List<Stop> getAllStopByDate(Date executionDate) {
        return stopRepository.findAllByExecutionDate(executionDate);
    }

    @Override
    public List<Stop> getAllStopByStatus(String status) {
        return stopRepository.findAllByStatus(status);
    }

    @Override
    public List<Stop> getAllStopByAssociatedJourney(Journey associatedJourney) {
        return stopRepository.findAllByAssociatedJourney(associatedJourney);
    }

    @Override
    public List<Stop> getAllStopByAssociatedRequest(Request associatedRequest) {
        return stopRepository.findAllByAssociatedRequest(associatedRequest);
    }

    @Override
    public Stop createStop(Stop stop) {
        return stopRepository.save(stop);
    }

    @Override
    public void updateStop(Stop stop) {
        if (stopRepository.existsById(stop.getStopId())) {
            stopRepository.save(stop);
        } else {
            throw new ObjectNotFoundException("Stop with id " + stop.getStopId() + " not found");
        }
    }

    @Override
    public void updateStopStatus(int stopId, String status) {
        Optional<Stop> optionalStop = stopRepository.findById(stopId);
        if (optionalStop.isPresent()) {
            Stop stop = optionalStop.get();
            stop.setStatus(status);
            stopRepository.save(stop);
        } else {
            throw new ObjectNotFoundException("Stop with id " + stopId + " not found");
        }
    }

    @Override
    public void updateStopRating(int stopId, int rating) {
        Optional<Stop> optionalStop = stopRepository.findById(stopId);
        if (optionalStop.isPresent()) {
            Stop stop = optionalStop.get();
            stop.setRating(rating);
            stopRepository.save(stop);
        } else {
            throw new ObjectNotFoundException("Stop with id " + stopId + " not found");
        }
    }

    @Override
    public void updateStopDetails(int stopId, String stopDetails) {
        Optional<Stop> optionalStop = stopRepository.findById(stopId);
        if (optionalStop.isPresent()) {
            Stop stop = optionalStop.get();
            stop.setStopDetails(stopDetails);
            stopRepository.save(stop);
        } else {
            throw new ObjectNotFoundException("Stop with id " + stopId + " not found");
        }
    }

    @Override
    public Stop getOrganizationRues(String rues) {
        return stopRepository.findByRues(rues).orElse(null);
    }

    @Override
    public Stop getOrganizationById(int stopId) {
        return stopRepository.findById(stopId).orElse(null);
    }
}