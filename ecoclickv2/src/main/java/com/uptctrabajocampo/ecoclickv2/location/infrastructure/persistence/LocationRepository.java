package com.uptctrabajocampo.ecoclickv2.location.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByGoogleLocationId(String googleLocationId);
    Optional<Location> findByAddress(String address);
}