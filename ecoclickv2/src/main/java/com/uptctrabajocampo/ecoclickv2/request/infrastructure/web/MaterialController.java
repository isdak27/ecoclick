package com.uptctrabajocampo.ecoclickv2.request.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.application.MaterialService;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {
    
    @Autowired
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Material>>> getAllMaterials() {
        return materialService.getAllMaterial();
    }

    @GetMapping("/findByType")
    public ResponseEntity<MessageRest<List<Material>>> getAllMaterialsByType(@RequestParam String materialType) {
        return materialService.getAllMaterialByMaterialType(materialType);
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Material>> createMaterial(@RequestBody Material material) {
        return materialService.createMaterial(material);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateMaterial(@RequestBody Material material) {
        return materialService.updateMaterial(material);
    }

    @PatchMapping("/update/name")
    public ResponseEntity<MessageRest<Void>> updateMaterialName(@RequestParam int materialId, @RequestParam String materialName) {
        return materialService.updateMaterialName(materialId, materialName);
    }

    @PatchMapping("/update/type")
    public ResponseEntity<MessageRest<Void>> updateMaterialType(@RequestParam int materialId, @RequestParam String materialType) {
        return materialService.updateMaterialType(materialId, materialType);
    }

    @PatchMapping("/update/address")
    public ResponseEntity<MessageRest<Void>> updateMaterialAddress(@RequestParam int materialId, @RequestParam int rating) {
        return materialService.updateMaterialAddress(materialId, rating);
    }

    @PatchMapping("/update/collectionProcedure")
    public ResponseEntity<MessageRest<Void>> updateMaterialCollectionProcedure(@RequestParam int materialId, @RequestParam String collectionProcedure) {
        return materialService.updateMaterialCollectionProcedure(materialId, collectionProcedure);
    }

    @PatchMapping("/update/treatmentInstruction")
    public ResponseEntity<MessageRest<Void>> updateMaterialTreatmentInstruction(@RequestParam int materialId, @RequestParam String treatmentInstruction) {
        return materialService.updateMaterialTreatmentInstruction(materialId, treatmentInstruction);
    }

    @PatchMapping("/update/recommendation")
    public ResponseEntity<MessageRest<Void>> updateMaterialRecommendation(@RequestParam int materialId, @RequestParam String recommendation) {
        return materialService.updateMaterialRecommendation(materialId, recommendation);
    }

    @PatchMapping("/update/referenceImage")
    public ResponseEntity<MessageRest<Void>> updateMaterialReferenceImage(@RequestParam int materialId, @RequestParam String referenceImage) {
        return materialService.updateMaterialReferenceImage(materialId, referenceImage);
    }

    @GetMapping("/findById")
    public ResponseEntity<MessageRest<Material>> getMaterialById(@RequestParam int materialId) {
        return materialService.getMaterialById(materialId);
    }

    @GetMapping("/findByName")
    public ResponseEntity<MessageRest<Material>> getMaterialByName(@RequestParam String materialName) {
        return materialService.getMaterialByName(materialName);
    }
}