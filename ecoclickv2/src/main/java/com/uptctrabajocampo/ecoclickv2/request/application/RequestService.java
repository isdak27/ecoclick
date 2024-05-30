package com.uptctrabajocampo.ecoclickv2.request.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.request.domain.RequestPort;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;

@Service
public class RequestService implements RequestRestPort {

    private final RequestPort requestPort;

    @Autowired
    public RequestService(RequestPort requestPort) {
        this.requestPort = requestPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Request>>> getAllRequest() {
        try {
            List<Request> requests = requestPort.getAllRequest();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), requests), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Request>>> getAllRequestByRequestingClient(Client requestingClient) {
        if (requestingClient == null || requestingClient.getClientId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Client", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Request> requests = requestPort.getAllRequestByRequestingClient(requestingClient);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), requests), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Request>>> getAllRequestByLocation(Location location) {
        if (location == null || location.getLocationId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Location", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Request> requests = requestPort.getAllRequestByLocation(location);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), requests), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Request>>> getAllRequestByRequestDate(Date requestDate) {
        if (requestDate == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Request Date", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Request> requests = requestPort.getAllRequestByRequestDate(requestDate);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), requests), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Request>> createRequest(Request request) {
        if (request == null || request.getRequestingClient() == null || request.getLocation() == null || request.getRequestDate() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request createdRequest = requestPort.createRequest(request);
            return new ResponseEntity<>(new MessageRest<>(1, "Request Created", HttpStatus.CREATED.value(), createdRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRequest(Request request) {
        if (request == null || request.getRequestId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request existingRequest = requestPort.getRequestById(request.getRequestId());
            if (existingRequest != null) {
                requestPort.updateRequest(request);
                return new ResponseEntity<>(new MessageRest<>(1, "Request Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Request Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRequestRequestingClient(int requestId, Client requestingClient) {
        if (requestId <= 0 || requestingClient == null || requestingClient.getClientId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request existingRequest = requestPort.getRequestById(requestId);
            if (existingRequest != null) {
                requestPort.updateRequestRequestingClient(requestId, requestingClient);
                return new ResponseEntity<>(new MessageRest<>(1, "Request Requesting Client Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Request Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRequestLocation(int requestId, Location location) {
        if (requestId <= 0 || location == null || location.getLocationId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request existingRequest = requestPort.getRequestById(requestId);
            if (existingRequest != null) {
                requestPort.updateRequestLocation(requestId, location);
                return new ResponseEntity<>(new MessageRest<>(1, "Request Location Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Request Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRequestRequestDate(int requestId, Date requestDate) {
        if (requestId <= 0 || requestDate == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request existingRequest = requestPort.getRequestById(requestId);
            if (existingRequest != null) {
                requestPort.updateRequestRequestDate(requestId, requestDate);
                return new ResponseEntity<>(new MessageRest<>(1, "Request Request Date Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Request Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRequestStatus(int requestId, String status) {
        if (requestId <= 0 || status == null || status.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request existingRequest = requestPort.getRequestById(requestId);
            if (existingRequest != null) {
                requestPort.updateRequestStatus(requestId, status);
                return new ResponseEntity<>(new MessageRest<>(1, "Request Status Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Request Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRequestImageReference(int requestId, String imageReference) {
        if (requestId <= 0 || imageReference == null || imageReference.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request existingRequest = requestPort.getRequestById(requestId);
            if (existingRequest != null) {
                requestPort.updateRequestImageReference(requestId, imageReference);
                return new ResponseEntity<>(new MessageRest<>(1, "Request Image Reference Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Request Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRequestDetails(int requestId, String details) {
        if (requestId <= 0 || details == null || details.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request existingRequest = requestPort.getRequestById(requestId);
            if (existingRequest != null) {
                requestPort.updateRequestDetails(requestId, details);
                return new ResponseEntity<>(new MessageRest<>(1, "Request Details Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Request Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Request>> getRequestById(int requestId) {
        if (requestId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Request ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Request request = requestPort.getRequestById(requestId);
            if (request != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), request), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Request Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}