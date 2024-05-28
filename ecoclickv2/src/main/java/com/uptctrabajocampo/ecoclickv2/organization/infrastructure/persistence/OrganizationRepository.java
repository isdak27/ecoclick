package com.uptctrabajocampo.ecoclickv2.organization.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Optional<Organization> findByRues(String rues);
    Optional<Organization> findByEnvironmentalLicense(String environmentalLicense);
    Optional<Organization> findByBusinessName(String businessName);
}