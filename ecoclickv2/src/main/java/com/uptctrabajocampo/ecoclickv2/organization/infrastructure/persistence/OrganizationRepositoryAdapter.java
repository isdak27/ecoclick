package com.uptctrabajocampo.ecoclickv2.organization.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;
import com.uptctrabajocampo.ecoclickv2.organization.domain.OrganizationPort;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;

@Component
public class OrganizationRepositoryAdapter implements OrganizationPort {

    private final OrganizationRepository organizationRepository;

    public OrganizationRepositoryAdapter(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<Organization> getAllOrganization() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public void updateOrganization(Organization organization) {
        if (organizationRepository.existsById(organization.getOrganizationId())) {
            organizationRepository.save(organization);
        } else {
            throw new ObjectNotFoundException("Organization with id " + organization.getOrganizationId() + " not found");
        }
    }

    @Override
    public void updateOrganizationbusinessName(int organizationId, String businessName) {
        Optional<Organization> optionalOrganization = organizationRepository.findById(organizationId);
        if (optionalOrganization.isPresent()) {
            Organization organization = optionalOrganization.get();
            organization.setBusinessName(businessName);
            organizationRepository.save(organization);
        } else {
            throw new ObjectNotFoundException("Organization with id " + organizationId + " not found");
        }
    }

    @Override
    public void updateOrganizationAddress(int organizationId, Location address) {
        Optional<Organization> optionalOrganization = organizationRepository.findById(organizationId);
        if (optionalOrganization.isPresent()) {
            Organization organization = optionalOrganization.get();
            organization.setAddress(address);
            organizationRepository.save(organization);
        } else {
            throw new ObjectNotFoundException("Organization with id " + organizationId + " not found");
        }
    }

    @Override
    public Organization getOrganizationRues(String rues) {
        return organizationRepository.findByRues(rues).orElse(null);
    }

    @Override
    public Organization getOrganizationById(int organizationId) {
        return organizationRepository.findById(organizationId).orElse(null);
    }

    @Override
    public Organization getOrganizationByEnvironmentalLicense(String environmentalLicense) {
        return organizationRepository.findByEnvironmentalLicense(environmentalLicense).orElse(null);
    }

    @Override
    public Organization getOrganizationByBusinessName(String businessName) {
        return organizationRepository.findByBusinessName(businessName).orElse(null);
    }
}