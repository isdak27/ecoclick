package com.uptctrabajocampo.ecoclickv2.organization.infrastructure.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uptctrabajocampo.ecoclickv2.organization.application.OrganizationService;
import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;

@Controller
@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    @Autowired
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllOrganizations() {
        return organizationService.getAllOrganization();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @PostMapping("/create/allParams")
    public ResponseEntity<?> createOrganization(
            @RequestParam String businessName,
            @RequestParam String rues,
            @RequestParam String environmentalLicense,
            @RequestParam String description,
            @RequestParam Date creationDate,
            @RequestParam String email,
            @RequestParam String alternativeEmail,
            @RequestParam String contactPhone,
            @RequestParam String alternativePhone,
            @RequestParam Location address) {
        return organizationService.createOrganization(businessName, rues, environmentalLicense, description, creationDate, email, alternativeEmail, contactPhone, alternativePhone, address);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrganization(@RequestBody Organization organization) {
        return organizationService.updateOrganization(organization);
    }

    @PatchMapping("/update/businessName")
    public ResponseEntity<?> updateOrganizationBusinessName(@RequestParam int organizationId, @RequestParam String businessName) {
        return organizationService.updateOrganizationbusinessName(organizationId, businessName);
    }

    @PatchMapping("/update/address")
    public ResponseEntity<?> updateOrganizationAddress(@RequestParam int organizationId, @RequestParam Location address) {
        return organizationService.updateOrganizationAddress(organizationId, address);
    }

    @GetMapping("/findByRues")
    public ResponseEntity<?> getOrganizationByRues(@RequestParam String rues) {
        return organizationService.getOrganizationRues(rues);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> getOrganizationById(@RequestParam int organizationId) {
        return organizationService.getOrganizationById(organizationId);
    }

    @GetMapping("/findByEnvironmentalLicense")
    public ResponseEntity<?> getOrganizationByEnvironmentalLicense(@RequestParam String environmentalLicense) {
        return organizationService.getOrganizationByEnvironmentalLicense(environmentalLicense);
    }

    @GetMapping("/findByBusinessName")
    public ResponseEntity<?> getOrganizationByBusinessName(@RequestParam String businessName) {
        return organizationService.getOrganizationByBusinessName(businessName);
    }
}