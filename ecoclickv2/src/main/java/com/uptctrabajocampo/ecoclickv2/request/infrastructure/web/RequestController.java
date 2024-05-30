package com.uptctrabajocampo.ecoclickv2.request.infrastructure.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.application.RequestService;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Request>>> getAllRequests() {
        return requestService.getAllRequest();
    }

    @GetMapping("/findByClient")
    public ResponseEntity<MessageRest<List<Request>>> getAllRequestsByClient(@RequestParam int clientId) {
        Client client = new Client();
        client.setClientId(clientId);
        return requestService.getAllRequestByRequestingClient(client);
    }

    @GetMapping("/findByLocation")
    public ResponseEntity<MessageRest<List<Request>>> getAllRequestsByLocation(@RequestParam int locationId) {
        Location location = new Location();
        location.setLocationId(locationId);
        return requestService.getAllRequestByLocation(location);
    }

    @GetMapping("/findByDate")
    public ResponseEntity<MessageRest<List<Request>>> getAllRequestsByDate(@RequestParam Date requestDate) {
        return requestService.getAllRequestByRequestDate(requestDate);
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Request>> createRequest(@RequestBody Request request) {
        return requestService.createRequest(request);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateRequest(@RequestBody Request request) {
        return requestService.updateRequest(request);
    }

    @PatchMapping("/updateClient")
    public ResponseEntity<MessageRest<Void>> updateRequestClient(@RequestParam int requestId, @RequestParam int clientId) {
        Client client = new Client();
        client.setClientId(clientId);
        return requestService.updateRequestRequestingClient(requestId, client);
    }

    @PatchMapping("/updateLocation")
    public ResponseEntity<MessageRest<Void>> updateRequestLocation(@RequestParam int requestId, @RequestParam int locationId) {
        Location location = new Location();
        location.setLocationId(locationId);
        return requestService.updateRequestLocation(requestId, location);
    }

    @PatchMapping("/updateDate")
    public ResponseEntity<MessageRest<Void>> updateRequestDate(@RequestParam int requestId, @RequestParam Date requestDate) {
        return requestService.updateRequestRequestDate(requestId, requestDate);
    }

    @PatchMapping("/updateStatus")
    public ResponseEntity<MessageRest<Void>> updateRequestStatus(@RequestParam int requestId, @RequestParam String status) {
        return requestService.updateRequestStatus(requestId, status);
    }

    @PatchMapping("/updateImageReference")
    public ResponseEntity<MessageRest<Void>> updateRequestImageReference(@RequestParam int requestId, @RequestParam String imageReference) {
        return requestService.updateRequestImageReference(requestId, imageReference);
    }

    @PatchMapping("/updateDetails")
    public ResponseEntity<MessageRest<Void>> updateRequestDetails(@RequestParam int requestId, @RequestParam String details) {
        return requestService.updateRequestDetails(requestId, details);
    }

    @GetMapping("/findById")
    public ResponseEntity<MessageRest<Request>> getRequestById(@RequestParam int requestId) {
        return requestService.getRequestById(requestId);
    }
}
