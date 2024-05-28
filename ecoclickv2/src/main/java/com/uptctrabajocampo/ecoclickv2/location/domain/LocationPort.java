package com.uptctrabajocampo.ecoclickv2.location.domain;

import java.util.List;

public interface LocationPort {

  List<Location> getAllLocations();
  void createLocation(Location location);
  void updateLocation(Location location);
  void updateLocationType(int locationId,String type);
  void updateLocationPhoto(int locationId,String photoUrl);
  Location getLocationByGoogleId(String googleLocationId);
  Location getLocationById(int locationId);
  Location getLocationByaddress(String address);
}
