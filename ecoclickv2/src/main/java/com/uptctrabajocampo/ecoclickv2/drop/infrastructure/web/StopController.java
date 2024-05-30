package com.uptctrabajocampo.ecoclickv2.drop.infrastructure.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uptctrabajocampo.ecoclickv2.drop.application.StopService;
import com.uptctrabajocampo.ecoclickv2.drop.domain.Stop;
import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;

@Controller
@RestController
@RequestMapping("/api/stops")
public class StopController {

    @Autowired
    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Stop>>> getAllStops() {
        return stopService.getAllStop();
    }

    @GetMapping("/findByDate")
    public ResponseEntity<MessageRest<List<Stop>>> getAllStopsByDate(@RequestParam Date executionDate) {
        return stopService.getAllStopByDate(executionDate);
    }

    @GetMapping("/findByStatus")
    public ResponseEntity<MessageRest<List<Stop>>> getAllStopsByStatus(@RequestParam String status) {
        return stopService.getAllStopByStatus(status);
    }

    @GetMapping("/findByJourney")
    public ResponseEntity<MessageRest<List<Stop>>> getAllStopsByJourney(@RequestBody Journey associatedJourney) {
        return stopService.getAllStopByAssociatedJourney(associatedJourney);
    }

    @GetMapping("/findByRequest")
    public ResponseEntity<MessageRest<List<Stop>>> getAllStopsByRequest(@RequestBody Request associatedRequest) {
        return stopService.getAllStopByAssociatedRequest(associatedRequest);
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Stop>> createStop(@RequestBody Stop stop) {
        return stopService.createStop(stop);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateStop(@RequestBody Stop stop) {
        return stopService.updateStop(stop);
    }

    @PatchMapping("/update/status")
    public ResponseEntity<MessageRest<Void>> updateStopStatus(@RequestParam int stopId, @RequestParam String status) {
        return stopService.updateStopStatus(stopId, status);
    }

    @PatchMapping("/update/rating")
    public ResponseEntity<MessageRest<Void>> updateStopRating(@RequestParam int stopId, @RequestParam int rating) {
        return stopService.updateStopRating(stopId, rating);
    }

    @PatchMapping("/update/details")
    public ResponseEntity<MessageRest<Void>> updateStopDetails(@RequestParam int stopId, @RequestParam String stopDetails) {
        return stopService.updateStopDetails(stopId, stopDetails);
    }
}
