package com.uptctrabajocampo.ecoclickv2.drop.application;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.drop.domain.Delivery;
import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;

public interface DeliveryRestPort {
  ResponseEntity<MessageRest<List<Delivery>>> getAllDelivery();
  ResponseEntity<MessageRest<List<Delivery>>> getAllDeliveryByRecycler();
  ResponseEntity<MessageRest<List<Delivery>>> getAllDeliveryByexecutionDate( Date executionDate);
  ResponseEntity<MessageRest<Delivery>> createDelivery(Delivery delivery);
  ResponseEntity<MessageRest<Void>> updateDelivery(Delivery delivery);
  ResponseEntity<MessageRest<Void>> updateDeliverystatus(int deliveryId,String status);
  ResponseEntity<MessageRest<Void>> updateDeliveryAddress(int deliveryId,int rating);
  ResponseEntity<MessageRest<Void>> updateDeliveryfeedback(int deliveryId,String feedback);
  ResponseEntity<MessageRest<Delivery>> getDeliveryRues(String rues);
  ResponseEntity<MessageRest<Delivery>> getDeliveryById(int deliveryId);
  ResponseEntity<MessageRest<Delivery>> getDeliveryByfeedback(String feedback);
  ResponseEntity<MessageRest<Delivery>> getDeliveryByEnvironmentalLicense(String feedback);
  ResponseEntity<MessageRest<Delivery>> getDeliveryByBusinessName(String businessName);
}
