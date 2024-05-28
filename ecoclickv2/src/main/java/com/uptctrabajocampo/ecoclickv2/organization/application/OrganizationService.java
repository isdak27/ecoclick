package com.uptctrabajocampo.ecoclickv2.organization.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;
import com.uptctrabajocampo.ecoclickv2.organization.domain.OrganizationPort;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;

@Service
public class OrganizationService implements OrganizationRestPort {

    @Autowired
    private final OrganizationPort organizationPort;

    public OrganizationService(OrganizationPort organizationPort) {
        this.organizationPort = organizationPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Organization>>> getAllOrganization() {
        try {
            List<Organization> organizations = organizationPort.getAllOrganization();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), organizations), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Organization>> createOrganization(Organization organization) {
        if (organization == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Organization createdOrganization = organizationPort.createOrganization(organization);
            return new ResponseEntity<>(new MessageRest<>(1, "Organization Created", HttpStatus.CREATED.value(), createdOrganization), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Organization>> createOrganization(String businessName, String rues, String environmentalLicense, String description,
                        Date creationDate, String email, String alternativeEmail, String contactPhone,
                        String alternativePhone, Location address) {
        Organization organization = new Organization(businessName, rues, environmentalLicense, description, creationDate, email, alternativeEmail, contactPhone, alternativePhone, address);
        return createOrganization(organization);
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateOrganization(Organization organization) {
        if (organization == null || organization.getOrganizationId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Organization existingOrganization = organizationPort.getOrganizationById(organization.getOrganizationId());
            if (existingOrganization != null) {
                organizationPort.updateOrganization(organization);
                return new ResponseEntity<>(new MessageRest<>(1, "Organization Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Organization Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateOrganizationbusinessName(int organizationId, String businessName) {
        try {
            Organization existingOrganization = organizationPort.getOrganizationById(organizationId);
            if (existingOrganization != null) {
                organizationPort.updateOrganizationbusinessName(organizationId, businessName);
                return new ResponseEntity<>(new MessageRest<>(1, "Organization Business Name Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Organization Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateOrganizationAddress(int organizationId, Location address) {
        try {
            Organization existingOrganization = organizationPort.getOrganizationById(organizationId);
            if (existingOrganization != null) {
                organizationPort.updateOrganizationAddress(organizationId, address);
                return new ResponseEntity<>(new MessageRest<>(1, "Organization Address Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Organization Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Organization>> getOrganizationRues(String rues) {
        if (rues == null || rues.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid RUES", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Organization organization = organizationPort.getOrganizationRues(rues);
            if (organization != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), organization), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Organization Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Organization>> getOrganizationById(int organizationId) {
        if (organizationId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Organization ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Organization organization = organizationPort.getOrganizationById(organizationId);
            if (organization != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), organization), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Organization Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Organization>> getOrganizationByEnvironmentalLicense(String environmentalLicense) {
        if (environmentalLicense == null || environmentalLicense.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Environmental License", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Organization organization = organizationPort.getOrganizationByEnvironmentalLicense(environmentalLicense);
            if (organization != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), organization), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Organization Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Organization>> getOrganizationByBusinessName(String businessName) {
        if (businessName == null || businessName.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Business Name", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Organization organization = organizationPort.getOrganizationByBusinessName(businessName);
            if (organization != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), organization), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Organization Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}