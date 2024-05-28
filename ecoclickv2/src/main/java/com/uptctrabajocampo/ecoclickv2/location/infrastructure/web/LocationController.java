package com.uptctrabajocampo.ecoclickv2.location.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.location.application.LocationService;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("/api/locations")
public class LocationController {
    
  
    @Autowired
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Location>>> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping("/create")
    ResponseEntity<MessageRest<Location>> createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @PostMapping("/create/allParams")
    ResponseEntity<MessageRest<Location>> createLocation(@RequestParam String googleLocationId,@RequestParam String address,@RequestParam double latitude,
    @RequestParam double longitude,@RequestParam String area,@RequestParam String city,@RequestParam int postalCode,@RequestParam String type,
    @RequestParam String photoUrl) {
        return locationService.createLocation(googleLocationId, address, latitude, longitude, area, city, postalCode, type, photoUrl);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateLocation(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }

    @PatchMapping("/update/type")
    public ResponseEntity<MessageRest<Void>> updateLocationType(@RequestParam int locationId,@RequestParam String type) {
        return locationService.updateLocationType(locationId,type);
    }

    @PatchMapping("/update/photo")
    public ResponseEntity<MessageRest<Void>> updateLocationPhoto(@RequestParam int locationId,@RequestParam String photoUrl) {
        return locationService.updateLocationPhoto(locationId,photoUrl);
    }

    @GetMapping("/findByGoogleId")
    public ResponseEntity<MessageRest<Location>> getLocationByGoogleId(@RequestParam String googleLocationId) {
        return locationService.getLocationByGoogleId(googleLocationId);
    }

    @GetMapping("/findByLocationId")
    public ResponseEntity<MessageRest<Location>> getLocationById(@RequestParam int locationId) {
        return locationService.getLocationById(locationId);
    }

    @GetMapping("/findByaddress")
    public ResponseEntity<MessageRest<Location>> getLocationByAddress(@RequestParam String address) {
        return locationService.getLocationByaddress(address);
    }

}
