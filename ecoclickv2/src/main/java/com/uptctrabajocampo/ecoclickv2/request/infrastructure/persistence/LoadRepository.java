package com.uptctrabajocampo.ecoclickv2.request.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.request.domain.Load;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;

public interface LoadRepository extends JpaRepository<Load, Integer> {
    List<Load> findAllByMaterial(Material material);
    List<Load> findAllByAssociatedPetition(Request associatedPetition);
    Optional<Load> findByReferenceImage(String referenceImage);
}