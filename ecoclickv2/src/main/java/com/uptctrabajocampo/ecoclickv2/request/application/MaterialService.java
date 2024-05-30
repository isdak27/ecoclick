package com.uptctrabajocampo.ecoclickv2.request.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;
import com.uptctrabajocampo.ecoclickv2.request.domain.MaterialPort;

@Service
public class MaterialService implements MaterialRestPort {

    private final MaterialPort materialPort;

    @Autowired
    public MaterialService(MaterialPort materialPort) {
        this.materialPort = materialPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Material>>> getAllMaterial() {
        try {
            List<Material> materials = materialPort.getAllMaterial();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), materials), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Material>>> getAllMaterialByMaterialType(String materialType) {
        if (materialType == null || materialType.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Material Type", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Material> materials = materialPort.getAllMaterialByMaterialType(materialType);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), materials), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Material>> createMaterial(Material material) {
        if (material == null || material.getMaterialName() == null || material.getMaterialType() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material createdMaterial = materialPort.createMaterial(material);
            return new ResponseEntity<>(new MessageRest<>(1, "Material Created", HttpStatus.CREATED.value(), createdMaterial), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateMaterial(Material material) {
        if (material == null || material.getMaterialId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material existingMaterial = materialPort.getMaterialById(material.getMaterialId());
            if (existingMaterial != null) {
                materialPort.updateMaterial(material);
                return new ResponseEntity<>(new MessageRest<>(1, "Material Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateMaterialName(int materialId, String materialName) {
        if (materialId <= 0 || materialName == null || materialName.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material existingMaterial = materialPort.getMaterialById(materialId);
            if (existingMaterial != null) {
                materialPort.updateMaterialName(materialId, materialName);
                return new ResponseEntity<>(new MessageRest<>(1, "Material Name Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateMaterialType(int materialId, String materialType) {
        if (materialId <= 0 || materialType == null || materialType.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material existingMaterial = materialPort.getMaterialById(materialId);
            if (existingMaterial != null) {
                materialPort.updateMaterialType(materialId, materialType);
                return new ResponseEntity<>(new MessageRest<>(1, "Material Type Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateMaterialAddress(int materialId, int rating) {
        if (materialId <= 0 || rating < 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material existingMaterial = materialPort.getMaterialById(materialId);
            if (existingMaterial != null) {
                materialPort.updateMaterialAddress(materialId, rating);
                return new ResponseEntity<>(new MessageRest<>(1, "Material Address Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateMaterialCollectionProcedure(int materialId, String collectionProcedure) {
        if (materialId <= 0 || collectionProcedure == null || collectionProcedure.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material existingMaterial = materialPort.getMaterialById(materialId);
            if (existingMaterial != null) {
                materialPort.updateMaterialCollectionProcedure(materialId, collectionProcedure);
                return new ResponseEntity<>(new MessageRest<>(1, "Material Collection Procedure Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateMaterialTreatmentInstruction(int materialId, String treatmentInstruction) {
        if (materialId <= 0 || treatmentInstruction == null || treatmentInstruction.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material existingMaterial = materialPort.getMaterialById(materialId);
            if (existingMaterial != null) {
                materialPort.updateMaterialTreatmentInstruction(materialId, treatmentInstruction);
                return new ResponseEntity<>(new MessageRest<>(1, "Material Treatment Instruction Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateMaterialRecommendation(int materialId, String recommendation) {
        if (materialId <= 0 || recommendation == null || recommendation.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material existingMaterial = materialPort.getMaterialById(materialId);
            if (existingMaterial != null) {
                materialPort.updateMaterialRecommendation(materialId, recommendation);
                return new ResponseEntity<>(new MessageRest<>(1, "Material Recommendation Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<MessageRest<Void>> updateMaterialReferenceImage(int materialId, String referenceImage) {
        if (materialId <= 0 || referenceImage == null || referenceImage.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material existingMaterial = materialPort.getMaterialById(materialId);
            if (existingMaterial != null) {
                materialPort.updateMaterialReferenceImage(materialId, referenceImage);
                return new ResponseEntity<>(new MessageRest<>(1, "Material Reference Image Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Material>> getMaterialById(int materialId) {
        if (materialId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Material ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material material = materialPort.getMaterialById(materialId);
            if (material != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), material), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Material>> getMaterialByName(String materialName) {
        if (materialName == null || materialName.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Material Name", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Material material = materialPort.getMaterialByName(materialName);
            if (material != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), material), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Material Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}