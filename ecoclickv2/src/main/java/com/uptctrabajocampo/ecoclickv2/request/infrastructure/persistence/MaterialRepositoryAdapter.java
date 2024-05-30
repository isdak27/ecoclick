package com.uptctrabajocampo.ecoclickv2.request.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.request.domain.Material;
import com.uptctrabajocampo.ecoclickv2.request.domain.MaterialPort;
import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;

@Component
public class MaterialRepositoryAdapter implements MaterialPort {

    private final MaterialRepository materialRepository;

    public MaterialRepositoryAdapter(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<Material> getAllMaterial() {
        return materialRepository.findAll();
    }

    @Override
    public List<Material> getAllMaterialByMaterialType(String materialType) {
        return materialRepository.findAllByMaterialType(materialType);
    }

    @Override
    public Material createMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public void updateMaterial(Material material) {
        if (materialRepository.existsById(material.getMaterialId())) {
            materialRepository.save(material);
        } else {
            throw new ObjectNotFoundException("Material with id " + material.getMaterialId() + " not found");
        }
    }

    @Override
    public void updateMaterialName(int materialId, String materialName) {
        Optional<Material> optionalMaterial = materialRepository.findById(materialId);
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setMaterialName(materialName);
            materialRepository.save(material);
        } else {
            throw new ObjectNotFoundException("Material with id " + materialId + " not found");
        }
    }

    @Override
    public void updateMaterialType(int materialId, String materialType) {
        Optional<Material> optionalMaterial = materialRepository.findById(materialId);
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setMaterialType(materialType);
            materialRepository.save(material);
        } else {
            throw new ObjectNotFoundException("Material with id " + materialId + " not found");
        }
    }

    @Override
    public void updateMaterialCollectionProcedure(int materialId, String collectionProcedure) {
        Optional<Material> optionalMaterial = materialRepository.findById(materialId);
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setCollectionProcedure(collectionProcedure);
            materialRepository.save(material);
        } else {
            throw new ObjectNotFoundException("Material with id " + materialId + " not found");
        }
    }

    @Override
    public void updateMaterialTreatmentInstruction(int materialId, String treatmentInstruction) {
        Optional<Material> optionalMaterial = materialRepository.findById(materialId);
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setTreatmentInstruction(treatmentInstruction);
            materialRepository.save(material);
        } else {
            throw new ObjectNotFoundException("Material with id " + materialId + " not found");
        }
    }

    @Override
    public void updateMaterialRecommendation(int materialId, String recommendation) {
        Optional<Material> optionalMaterial = materialRepository.findById(materialId);
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setRecommendation(recommendation);
            materialRepository.save(material);
        } else {
            throw new ObjectNotFoundException("Material with id " + materialId + " not found");
        }
    }

    @Override
    public void updateMaterialReferenceImage(int materialId, String referenceImage) {
        Optional<Material> optionalMaterial = materialRepository.findById(materialId);
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setReferenceImage(referenceImage);
            materialRepository.save(material);
        } else {
            throw new ObjectNotFoundException("Material with id " + materialId + " not found");
        }
    }

    @Override
    public Material getMaterialById(int materialId) {
        return materialRepository.findById(materialId).orElse(null);
    }

    @Override
    public Material getMaterialByName(String materialName) {
        return materialRepository.findByMaterialName(materialName).orElse(null);
    }

    @Override
    public void updateMaterialAddress(int materialId, int rating) {
        throw new UnsupportedOperationException("Unimplemented method 'updateMaterialAddress'");
    }
}