package com.uptctrabajocampo.ecoclickv2.location.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.location.domain.LocationPort;

@Component
public class LocationRepositoryAdapter implements LocationPort{
    
    @Autowired
    private final LocationRepository locationRepository;

    public LocationRepositoryAdapter(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public void createLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void updateLocationType(int locationId, String type) {
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        if (optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setType(type);
            locationRepository.save(location);
        } else {
            // Manejar el caso en que no se encuentre la ubicación
            throw new ObjectNotFoundException("Location with id " + locationId + " not found");
        }
    }

    @Override
    public void updateLocationPhoto(int locationId, String photoUrl) {
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        if (optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setPhotoUrl(photoUrl);
            locationRepository.save(location);
        } else {
            // Manejar el caso en que no se encuentre la ubicación
            throw new ObjectNotFoundException("Location with id " + locationId + " not found");
        }
    }

    @Override
    public Location getLocationByGoogleId(String googleLocationId) {
        return locationRepository.findByGoogleLocationId(googleLocationId).orElse(null);
    }

    @Override
    public Location getLocationById(int locationId) {
        return locationRepository.findById(locationId).orElse(null);
    }

    @Override
    public Location getLocationByaddress(String address) {
        return locationRepository.findByAddress(address).orElse(null);
    }
}
