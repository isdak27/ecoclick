package com.uptctrabajocampo.ecoclickv2.location.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.location.domain.LocationPort;

@Service
public class LocationService implements LocationRestPort {

    @Autowired
    private final LocationPort locationPort;

    public LocationService(LocationPort locationPort) {
        this.locationPort = locationPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Location>>> getAllLocations() {
        try {
            List<Location> locations = locationPort.getAllLocations();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), locations), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Location>> createLocation(Location location) {
        if (location == null || location.getAddress() == null || location.getGoogleLocationId() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            locationPort.createLocation(location);
            return new ResponseEntity<>(new MessageRest<>(1, "Location Created", HttpStatus.CREATED.value(), location), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Location>> createLocation(String googleLocationId, String address, double latitude,
            double longitude, String area, String city, int postalCode, String type, String photoUrl) {
        Location location = new Location(googleLocationId, address, latitude, longitude, area, city, postalCode, type, photoUrl);
        return createLocation(location);
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLocation(Location location) {
        if (location == null || location.getLocationId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Location existingLocation = locationPort.getLocationById(location.getLocationId());
            if (existingLocation != null) {
                locationPort.updateLocation(location);
                return new ResponseEntity<>(new MessageRest<>(1, "Location Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Location Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLocationType(int locationId, String type) {
        if (type == null || type.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            locationPort.updateLocationType(locationId, type);
            return new ResponseEntity<>(new MessageRest<>(1, "Location Type Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLocationPhoto(int locationId, String photoUrl) {
        if (photoUrl == null || photoUrl.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            locationPort.updateLocationPhoto(locationId, photoUrl);
            return new ResponseEntity<>(new MessageRest<>(1, "Location Photo Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Location>> getLocationByGoogleId(String googleLocationId) {
        if (googleLocationId == null || googleLocationId.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Location location = locationPort.getLocationByGoogleId(googleLocationId);
            if (location != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), location), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Location Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Location>> getLocationById(int locationId) {
        if (locationId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Location location = locationPort.getLocationById(locationId);
            if (location != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), location), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Location Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Location>> getLocationByaddress(String address) {
        if (address == null || address.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Location location = locationPort.getLocationByaddress(address);
            if (location != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), location), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Location Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}