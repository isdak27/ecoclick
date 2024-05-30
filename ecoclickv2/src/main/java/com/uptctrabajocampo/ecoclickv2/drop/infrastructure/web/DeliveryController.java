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

import com.uptctrabajocampo.ecoclickv2.drop.application.DeliveryService;
import com.uptctrabajocampo.ecoclickv2.drop.domain.Delivery;
import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;

@Controller
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    
    @Autowired
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Delivery>>> getAllDeliveries() {
        return deliveryService.getAllDelivery();
    }

    @GetMapping("/findByRecycler")
    public ResponseEntity<MessageRest<List<Delivery>>> getAllDeliveriesByRecycler() {
        return deliveryService.getAllDeliveryByRecycler();
    }

    @GetMapping("/findByExecutionDate")
    public ResponseEntity<MessageRest<List<Delivery>>> getAllDeliveriesByExecutionDate(@RequestParam Date executionDate) {
        return deliveryService.getAllDeliveryByexecutionDate(executionDate);
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Delivery>> createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.createDelivery(delivery);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateDelivery(@RequestBody Delivery delivery) {
        return deliveryService.updateDelivery(delivery);
    }

    @PatchMapping("/update/status")
    public ResponseEntity<MessageRest<Void>> updateDeliveryStatus(@RequestParam int deliveryId, @RequestParam String status) {
        return deliveryService.updateDeliverystatus(deliveryId, status);
    }

    @PatchMapping("/update/rating")
    public ResponseEntity<MessageRest<Void>> updateDeliveryRating(@RequestParam int deliveryId, @RequestParam int rating) {
        return deliveryService.updateDeliveryAddress(deliveryId, rating);
    }

    @PatchMapping("/update/feedback")
    public ResponseEntity<MessageRest<Void>> updateDeliveryFeedback(@RequestParam int deliveryId, @RequestParam String feedback) {
        return deliveryService.updateDeliveryfeedback(deliveryId, feedback);
    }

    @GetMapping("/findById")
    public ResponseEntity<MessageRest<Delivery>> getDeliveryById(@RequestParam int deliveryId) {
        return deliveryService.getDeliveryById(deliveryId);
    }

    @GetMapping("/findByFeedback")
    public ResponseEntity<MessageRest<Delivery>> getDeliveryByFeedback(@RequestParam String feedback) {
        return deliveryService.getDeliveryByfeedback(feedback);
    }

}