package com.uptctrabajocampo.ecoclickv2.route.infrastructure.web;

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
import com.uptctrabajocampo.ecoclickv2.route.application.JourneyService;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;
import com.uptctrabajocampo.ecoclickv2.route.domain.Route;

@RestController
@RequestMapping("/api/journeys")
public class JourneyController {

    @Autowired
    private final JourneyService journeyService;

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Journey>>> getAllJourneys() {
        return journeyService.getAllJourneyS();
    }

    @GetMapping("/findByAssignedRoute")
    public ResponseEntity<MessageRest<List<Journey>>> getAllJourneysByAssignedRoute(@RequestBody Route assignedRoute) {
        return journeyService.getAllJourneyByassignedRoute(assignedRoute);
    }

    @GetMapping("/findByDate")
    public ResponseEntity<MessageRest<List<Journey>>> getAllJourneysByDate(@RequestParam Date executionDate) {
        return journeyService.getAllJourneyByDate(executionDate);
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Journey>> createJourney(@RequestBody Journey journey) {
        return journeyService.createJourney(journey);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateJourney(@RequestBody Journey journey) {
        return journeyService.updateJourney(journey);
    }

    @PatchMapping("/update/assignedRoute")
    public ResponseEntity<MessageRest<Void>> updateJourneyAssignedRoute(@RequestParam int journeyId, @RequestBody Route assignedRoute) {
        return journeyService.updateJourneyAssignedRoute(journeyId, assignedRoute);
    }

    @PatchMapping("/update/executionDate")
    public ResponseEntity<MessageRest<Void>> updateJourneyExecutionDate(@RequestParam int journeyId, @RequestParam Date executionDate) {
        return journeyService.updateJourneyExecutionDate(journeyId, executionDate);
    }

    @PatchMapping("/update/details")
    public ResponseEntity<MessageRest<Void>> updateJourneyDetails(@RequestParam int journeyId, @RequestParam String journeyDetails) {
        return journeyService.updateJourneyDetails(journeyId, journeyDetails);
    }

    @GetMapping("/findById")
    public ResponseEntity<MessageRest<Journey>> getJourneyById(@RequestParam int journeyId) {
        return journeyService.getJourneyById(journeyId);
    }
}