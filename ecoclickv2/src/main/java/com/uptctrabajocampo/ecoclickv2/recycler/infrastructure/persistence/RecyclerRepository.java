package com.uptctrabajocampo.ecoclickv2.recycler.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;

public interface RecyclerRepository extends JpaRepository<Recycler, Integer>{
    Optional<Recycler> findByEnvironmentalLicense(String environmentalLicense);
    Optional<Recycler> findByDocumentNumber(String documentNumber);
    Optional<Recycler> findByEmail(String email);
}
