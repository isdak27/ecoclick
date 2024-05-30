package com.uptctrabajocampo.ecoclickv2.request.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.application.LoadService;
import com.uptctrabajocampo.ecoclickv2.request.domain.Load;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;

@RestController
@RequestMapping("/api/loads")
public class LoadController {

    private final LoadService loadService;

    @Autowired
    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Load>>> getAllLoads() {
        return loadService.getAllLoad();
    }

    @GetMapping("/findByMaterial")
    public ResponseEntity<MessageRest<List<Load>>> getAllLoadsByMaterial(@RequestParam Material material) {
        return loadService.getAllLoadByMaterial(material);
    }

    @GetMapping("/findByAssociatedPetition")
    public ResponseEntity<MessageRest<List<Load>>> getAllLoadsByAssociatedPetition(@RequestParam Request associatedPetition) {
        return loadService.getAllLoadByAssociatedPetition(associatedPetition);
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Load>> createLoad(@RequestBody Load load) {
        return loadService.createLoad(load);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateLoad(@RequestBody Load load) {
        return loadService.updateLoad(load);
    }

    @PatchMapping("/update/estimateWeight")
    public ResponseEntity<MessageRest<Void>> updateLoadEstimateWeight(@RequestParam int loadId, @RequestParam int estimatedWeight) {
        return loadService.updateLoadestimateWeight(loadId, estimatedWeight);
    }

    @PatchMapping("/update/estimateHeight")
    public ResponseEntity<MessageRest<Void>> updateLoadEstimateHeight(@RequestParam int loadId, @RequestParam int estimatedHeight) {
        return loadService.updateLoadestimateHeight(loadId, estimatedHeight);
    }

    @PatchMapping("/update/estimateWidth")
    public ResponseEntity<MessageRest<Void>> updateLoadEstimateWidth(@RequestParam int loadId, @RequestParam int estimatedWidth) {
        return loadService.updateLoadestimatedWidth(loadId, estimatedWidth);
    }

    @PatchMapping("/update/material")
    public ResponseEntity<MessageRest<Void>> updateLoadMaterial(@RequestParam int loadId, @RequestParam Material material) {
        return loadService.updateLoadMaterial(loadId, material);
    }

    @PatchMapping("/update/associatedPetition")
    public ResponseEntity<MessageRest<Void>> updateLoadAssociatedPetition(@RequestParam int loadId, @RequestParam Request associatedPetition) {
        return loadService.updateLoadAssociatedPetition(loadId, associatedPetition);
    }

    @PatchMapping("/update/referenceImage")
    public ResponseEntity<MessageRest<Void>> updateLoadReferenceImage(@RequestParam int loadId, @RequestParam String referenceImage) {
        return loadService.updateLoadReferenceImage(loadId, referenceImage);
    }

    @GetMapping("/findById")
    public ResponseEntity<MessageRest<Load>> getLoadById(@RequestParam int loadId) {
        return loadService.getLoadById(loadId);
    }
}