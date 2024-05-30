package com.uptctrabajocampo.ecoclickv2.drop.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.drop.domain.Delivery;
import com.uptctrabajocampo.ecoclickv2.drop.domain.DeliveryPort;
import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;

@Component
public class DeliveryRepositoryAdapter implements DeliveryPort {

    private final DeliveryRepository deliveryRepository;

    public DeliveryRepositoryAdapter(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.findAll();
    }

    @Override
    public List<Delivery> getAllDeliveryByRecycler() {
        return List.of();
    }

    @Override
    public List<Delivery> getAllDeliveryByexecutionDate(Date executionDate) {
        return deliveryRepository.findAllByExecutionDate(executionDate);
    }

    @Override
    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        if (deliveryRepository.existsById(delivery.getDeliveryId())) {
            deliveryRepository.save(delivery);
        } else {
            throw new ObjectNotFoundException("Delivery with id " + delivery.getDeliveryId() + " not found");
        }
    }

    @Override
    public void updateDeliverystatus(int deliveryId, String status) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            delivery.setStatus(status);
            deliveryRepository.save(delivery);
        } else {
            throw new ObjectNotFoundException("Delivery with id " + deliveryId + " not found");
        }
    }

    @Override
    public void updateDeliveryRating(int deliveryId, int rating) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            delivery.setRating(rating);
            deliveryRepository.save(delivery);
        } else {
            throw new ObjectNotFoundException("Delivery with id " + deliveryId + " not found");
        }
    }

    @Override
    public void updateDeliveryfeedback(int deliveryId, String feedback) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            delivery.setFeedback(feedback);
            deliveryRepository.save(delivery);
        } else {
            throw new ObjectNotFoundException("Delivery with id " + deliveryId + " not found");
        }
    }

    @Override
    public Delivery getDeliveryById(int deliveryId) {
        return deliveryRepository.findById(deliveryId).orElse(null);
    }

    @Override
    public Delivery getDeliveryByfeedback(String feedback) {
        return deliveryRepository.findByFeedback(feedback).orElse(null);
    }

}