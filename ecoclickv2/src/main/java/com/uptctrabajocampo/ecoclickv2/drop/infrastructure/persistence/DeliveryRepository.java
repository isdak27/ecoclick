package com.uptctrabajocampo.ecoclickv2.drop.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.drop.domain.Delivery;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    List<Delivery> findAllByAssignedRecycler(Recycler recycler);
    List<Delivery> findAllByExecutionDate(Date executionDate);
    Optional<Delivery> findByFeedback(String feedback);
}