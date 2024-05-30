package com.uptctrabajocampo.ecoclickv2.request.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.request.domain.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    List<Material> findAllByMaterialType(String materialType);
    Optional<Material> findByMaterialName(String materialName);
}
