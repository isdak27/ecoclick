package com.uptctrabajocampo.ecoclickv2.organization.application;

import java.util.Date;
import java.util.List;


import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;

public interface OrganizationRestPort {
    ResponseEntity<MessageRest<List<Organization>>> getAllOrganization();
    ResponseEntity<MessageRest<Organization>> createOrganization(Organization organization);
    ResponseEntity<MessageRest<Organization>> createOrganization(String businessName, String rues, String environmentalLicense, String description,
                        Date creationDate, String email, String alternativeEmail, String contactPhone,
                        String alternativePhone, Location address);
    ResponseEntity<MessageRest<Void>> updateOrganization(Organization organization);
    ResponseEntity<MessageRest<Void>> updateOrganizationbusinessName(int organizationId,String businessName);
    ResponseEntity<MessageRest<Void>> updateOrganizationAddress(int organizationId,Location address);
    ResponseEntity<MessageRest<Organization>> getOrganizationRues(String rues);
    ResponseEntity<MessageRest<Organization>> getOrganizationById(int organizationId);
    ResponseEntity<MessageRest<Organization>> getOrganizationByEnvironmentalLicense(String environmentalLicense);
    ResponseEntity<MessageRest<Organization>> getOrganizationByBusinessName(String businessName);

}
