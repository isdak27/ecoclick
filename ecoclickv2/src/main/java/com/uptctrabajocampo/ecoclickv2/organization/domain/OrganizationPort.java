package com.uptctrabajocampo.ecoclickv2.organization.domain;

import java.util.List;

import com.uptctrabajocampo.ecoclickv2.location.domain.Location;

public interface OrganizationPort {
  List<Organization> getAllOrganization();
  Organization createOrganization(Organization organization);
  void updateOrganization(Organization organization);
  void updateOrganizationbusinessName(int organizationId,String businessName);
  void updateOrganizationAddress(int organizationId,Location address);
  Organization getOrganizationRues(String rues);
  Organization getOrganizationById(int organizationId);
  Organization getOrganizationByEnvironmentalLicense(String environmentalLicense);
  Organization getOrganizationByBusinessName(String businessName);
}
