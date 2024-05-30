package com.uptctrabajocampo.ecoclickv2.request.infrastructure.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;

public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> findAllByRequestingClient(Client requestingClient);
    List<Request> findAllByLocation(Location location);
    List<Request> findAllByRequestDate(Date requestDate);
}