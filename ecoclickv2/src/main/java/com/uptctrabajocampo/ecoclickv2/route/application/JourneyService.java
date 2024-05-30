package com.uptctrabajocampo.ecoclickv2.route.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;
import com.uptctrabajocampo.ecoclickv2.route.domain.JourneyPort;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;

@Service
public class JourneyService implements JourneyRestPort {

    @Autowired
    private final JourneyPort journeyPort;

    public JourneyService(JourneyPort journeyPort) {
        this.journeyPort = journeyPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Journey>>> getAllJourneyS() {
        try {
            List<Journey> journeys = journeyPort.getAllJourneys();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), journeys), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Journey>>> getAllJourneyByassignedRoute(Route assignedRoute) {
        try {
            List<Journey> journeys = journeyPort.getAllJourneyByAssignedRoute(assignedRoute);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), journeys), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Journey>>> getAllJourneyByDate(Date executionDate) {
        try {
            List<Journey> journeys = journeyPort.getAllJourneyByDate(executionDate);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), journeys), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Journey>> createJourney(Journey journey) {
        if (journey == null || journey.getAssignedRoute() == null || journey.getExecutionDate() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            journeyPort.createJourney(journey);
            return new ResponseEntity<>(new MessageRest<>(1, "Journey Created", HttpStatus.CREATED.value(), journey), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateJourney(Journey journey) {
        if (journey == null || journey.getJourneyId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Journey existingJourney = journeyPort.getJourneyById(journey.getJourneyId());
            if (existingJourney != null) {
                journeyPort.updateJourney(journey);
                return new ResponseEntity<>(new MessageRest<>(1, "Journey Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Journey Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateJourneyAssignedRoute(int journeyId, Route assignedRoute) {
        try {
            Journey existingJourney = journeyPort.getJourneyById(journeyId);
            if (existingJourney != null) {
                journeyPort.updateJourneyAssignedRoute(journeyId, assignedRoute);
                return new ResponseEntity<>(new MessageRest<>(1, "Journey Assigned Route Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Journey Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateJourneyExecutionDate(int journeyId, Date executionDate) {
        try {
            Journey existingJourney = journeyPort.getJourneyById(journeyId);
            if (existingJourney != null) {
                journeyPort.updateJourneyExecutionDate(journeyId, executionDate);
                return new ResponseEntity<>(new MessageRest<>(1, "Journey Execution Date Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Journey Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateJourneyDetails(int journeyId, String journeyDetails) {
        try {
            Journey existingJourney = journeyPort.getJourneyById(journeyId);
            if (existingJourney != null) {
                journeyPort.updateJourneyDetails(journeyId, journeyDetails);
                return new ResponseEntity<>(new MessageRest<>(1, "Journey Details Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Journey Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Journey>> getJourneyById(int journeyId) {
        if (journeyId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Journey ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Journey journey = journeyPort.getJourneyById(journeyId);
            if (journey != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), journey), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Journey Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}




