package com.uptctrabajocampo.ecoclickv2.drop.domain;

import java.util.Date;
import java.util.List;


public interface DeliveryPort {
  List<Delivery> getAllDelivery();
  List<Delivery> getAllDeliveryByRecycler();
  List<Delivery> getAllDeliveryByexecutionDate( Date executionDate);
  Delivery createDelivery(Delivery delivery);
  void updateDelivery(Delivery delivery);
  void updateDeliverystatus(int deliveryId,String status);
  void updateDeliveryRating(int deliveryId,int rating);
  void updateDeliveryfeedback(int deliveryId,String feedback);
  Delivery getDeliveryById(int deliveryId);
  Delivery getDeliveryByfeedback(String feedback);

}
