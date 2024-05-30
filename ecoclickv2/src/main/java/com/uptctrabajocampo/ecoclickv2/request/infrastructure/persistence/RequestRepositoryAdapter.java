package com.uptctrabajocampo.ecoclickv2.request.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.request.domain.RequestPort;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;
import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;

@Component
public class RequestRepositoryAdapter implements RequestPort {

    private final RequestRepository requestRepository;

    public RequestRepositoryAdapter(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<Request> getAllRequest() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> getAllRequestByRequestingClient(Client requestingClient) {
        return requestRepository.findAllByRequestingClient(requestingClient);
    }

    @Override
    public List<Request> getAllRequestByLocation(Location location) {
        return requestRepository.findAllByLocation(location);
    }

    @Override
    public List<Request> getAllRequestByRequestDate(Date requestDate) {
        return requestRepository.findAllByRequestDate(requestDate);
    }

    @Override
    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public void updateRequest(Request request) {
        if (requestRepository.existsById(request.getRequestId())) {
            requestRepository.save(request);
        } else {
            throw new ObjectNotFoundException("Request with id " + request.getRequestId() + " not found");
        }
    }

    @Override
    public void updateRequestRequestingClient(int requestId, Client requestingClient) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setRequestingClient(requestingClient);
            requestRepository.save(request);
        } else {
            throw new ObjectNotFoundException("Request with id " + requestId + " not found");
        }
    }

    @Override
    public void updateRequestLocation(int requestId, Location location) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setLocation(location);
            requestRepository.save(request);
        } else {
            throw new ObjectNotFoundException("Request with id " + requestId + " not found");
        }
    }

    @Override
    public void updateRequestRequestDate(int requestId, Date requestDate) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setRequestDate(requestDate);
            requestRepository.save(request);
        } else {
            throw new ObjectNotFoundException("Request with id " + requestId + " not found");
        }
    }

    @Override
    public void updateRequestStatus(int requestId, String status) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setStatus(status);
            requestRepository.save(request);
        } else {
            throw new ObjectNotFoundException("Request with id " + requestId + " not found");
        }
    }

    @Override
    public void updateRequestImageReference(int requestId, String imageReference) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setImageReference(imageReference);
            requestRepository.save(request);
        } else {
            throw new ObjectNotFoundException("Request with id " + requestId + " not found");
        }
    }

    @Override
    public void updateRequestDetails(int requestId, String details) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setDetails(details);
            requestRepository.save(request);
        } else {
            throw new ObjectNotFoundException("Request with id " + requestId + " not found");
        }
    }

    @Override
    public Request getRequestById(int requestId) {
        return requestRepository.findById(requestId).orElse(null);
    }
}
