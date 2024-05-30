package com.uptctrabajocampo.ecoclickv2.drop.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.drop.domain.Delivery;
import com.uptctrabajocampo.ecoclickv2.drop.domain.DeliveryPort;
import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;

@Service
public class DeliveryService implements DeliveryRestPort {

    private final DeliveryPort deliveryPort;

    @Autowired
    public DeliveryService(DeliveryPort deliveryPort) {
        this.deliveryPort = deliveryPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Delivery>>> getAllDelivery() {
        try {
            List<Delivery> deliveries = deliveryPort.getAllDelivery();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), deliveries), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Delivery>>> getAllDeliveryByRecycler(Recycler recycler) {
        try {
            List<Delivery> deliveries = deliveryPort.getAllDeliveryByRecycler(recycler);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), deliveries), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Delivery>>> getAllDeliveryByexecutionDate(Date executionDate) {
        if (executionDate == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Date", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Delivery> deliveries = deliveryPort.getAllDeliveryByexecutionDate(executionDate);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), deliveries), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Delivery>> createDelivery(Delivery delivery) {
        if (delivery == null || delivery.getExecutionDate() == null || delivery.getStatus() == null || delivery.getDeliveryDetails() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Delivery createdDelivery = deliveryPort.createDelivery(delivery);
            return new ResponseEntity<>(new MessageRest<>(1, "Delivery Created", HttpStatus.CREATED.value(), createdDelivery), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateDelivery(Delivery delivery) {
        if (delivery == null || delivery.getDeliveryId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Delivery existingDelivery = deliveryPort.getDeliveryById(delivery.getDeliveryId());
            if (existingDelivery != null) {
                deliveryPort.updateDelivery(delivery);
                return new ResponseEntity<>(new MessageRest<>(1, "Delivery Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Delivery Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateDeliverystatus(int deliveryId, String status) {
        if (deliveryId <= 0 || status == null || status.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Delivery existingDelivery = deliveryPort.getDeliveryById(deliveryId);
            if (existingDelivery != null) {
                deliveryPort.updateDeliverystatus(deliveryId, status);
                return new ResponseEntity<>(new MessageRest<>(1, "Delivery Status Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Delivery Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateDeliveryAddress(int deliveryId, int rating) {
        if (deliveryId <= 0 || rating < 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Delivery existingDelivery = deliveryPort.getDeliveryById(deliveryId);
            if (existingDelivery != null) {
                deliveryPort.updateDeliveryRating(deliveryId, rating);
                return new ResponseEntity<>(new MessageRest<>(1, "Delivery Address Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Delivery Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateDeliveryfeedback(int deliveryId,String feedback) {
        if (feedback == null || feedback.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Feedback", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            deliveryPort.updateDeliveryfeedback(deliveryId,feedback);
            return new ResponseEntity<>(new MessageRest<>(1, "Delivery Feedback Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Delivery>> getDeliveryById(int deliveryId) {
        if (deliveryId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Delivery ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Delivery delivery = deliveryPort.getDeliveryById(deliveryId);
            if (delivery != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), delivery), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Delivery Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Delivery>> getDeliveryByfeedback(String feedback) {
        if (feedback == null || feedback.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Feedback", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Delivery delivery = deliveryPort.getDeliveryByfeedback(feedback);
            if (delivery != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), delivery), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Delivery Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
