package com.uptctrabajocampo.ecoclickv2.location.application;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;

public interface LocationRestPort {
  ResponseEntity<MessageRest<List<Location>>> getAllLocations();
  ResponseEntity<MessageRest<Location>> createLocation(Location persona);
  ResponseEntity<MessageRest<Location>>  createLocation(String googleLocationId, String address,
  double latitude, double longitude,String area, String city, int postalCode, 
  String type, String photoUrl);
  ResponseEntity<MessageRest<Void>> updateLocation(Location persona);
  ResponseEntity<MessageRest<Void>> updateLocationType(int locationId,String type);
  ResponseEntity<MessageRest<Void>> updateLocationPhoto(int locationId,String photoUrl);
  ResponseEntity<MessageRest<Location>> getLocationByGoogleId(String googleLocationId);
  ResponseEntity<MessageRest<Location>> getLocationById(int locationId);
  ResponseEntity<MessageRest<Location>> getLocationByaddress(String address);
}
