package com.uptctrabajocampo.ecoclickv2.drop.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.drop.domain.Stop;
import com.uptctrabajocampo.ecoclickv2.drop.domain.StopPort;
import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;

@Service
public class StopService implements StopRestPort {

    private final StopPort stopPort;

    @Autowired
    public StopService(StopPort stopPort) {
        this.stopPort = stopPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Stop>>> getAllStop() {
        try {
            List<Stop> stops = stopPort.getAllStop();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), stops), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Stop>>> getAllStopByDate(Date executionDate) {
        if (executionDate == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Date", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Stop> stops = stopPort.getAllStopByDate(executionDate);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), stops), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Stop>>> getAllStopByStatus(String status) {
        if (status == null || status.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Status", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Stop> stops = stopPort.getAllStopByStatus(status);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), stops), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Stop>>> getAllStopByAssociatedJourney(Journey associatedJourney) {
        if (associatedJourney == null || associatedJourney.getJourneyId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Journey", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Stop> stops = stopPort.getAllStopByAssociatedJourney(associatedJourney);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), stops), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Stop>>> getAllStopByAssociatedJourney(Request associatedRequest) {
        if (associatedRequest == null || associatedRequest.getRequestId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Request", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Stop> stops = stopPort.getAllStopByAssociatedRequest(associatedRequest);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), stops), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Stop>> createStop(Stop stop) {
        if (stop == null || stop.getExecutionDate() == null || stop.getStatus() == null || stop.getStopDetails() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Stop createdStop = stopPort.createStop(stop);
            return new ResponseEntity<>(new MessageRest<>(1, "Stop Created", HttpStatus.CREATED.value(), createdStop), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateStop(Stop stop) {
        if (stop == null || stop.getStopId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Stop existingStop = stopPort.getOrganizationById(stop.getStopId());
            if (existingStop != null) {
                stopPort.updateStop(stop);
                return new ResponseEntity<>(new MessageRest<>(1, "Stop Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Stop Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateStopStatus(int stopId, String status) {
        if (stopId <= 0 || status == null || status.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Stop existingStop = stopPort.getOrganizationById(stopId);
            if (existingStop != null) {
                stopPort.updateStopStatus(stopId, status);
                return new ResponseEntity<>(new MessageRest<>(1, "Stop Status Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Stop Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateStopRating(int stopId, int rating) {
        if (stopId <= 0 || rating < 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Stop existingStop = stopPort.getOrganizationById(stopId);
            if (existingStop != null) {
                stopPort.updateStopRating(stopId, rating);
                return new ResponseEntity<>(new MessageRest<>(1, "Stop Rating Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Stop Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateStopDetails(int stopId, String stopDetails) {
        if (stopId <= 0 || stopDetails == null || stopDetails.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Stop existingStop = stopPort.getOrganizationById(stopId);
            if (existingStop != null) {
                stopPort.updateStopDetails(stopId, stopDetails);
                return new ResponseEntity<>(new MessageRest<>(1, "Stop Details Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Stop Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Stop>> getOrganizationRues(String rues) {
        if (rues == null || rues.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid RUES", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Stop stop = stopPort.getOrganizationRues(rues);
            if (stop != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), stop), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Stop Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Stop>> getOrganizationById(int stopId) {
        if (stopId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Stop ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Stop stop = stopPort.getOrganizationById(stopId);
            if (stop != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), stop), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Stop Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}