package com.uptctrabajocampo.ecoclickv2.request.application;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;

public interface MaterialRestPort {
  ResponseEntity<MessageRest<List<Material>>> getAllMaterial();
  ResponseEntity<MessageRest<List<Material>>> getAllMaterialByMaterialType(String materialType);
  Material createMaterial(Material material);
  void updateMaterial(Material material);
  void updateMaterialName(int materialId,String materialName);
  void updateMaterialType(int materialId,String materialType);
  void updateMaterialAddress(int materialId,int rating);
  void updateMaterialCollectionProcedure(int materialId,String collectionProcedure);
  void updateMaterialTreatmentInstruction(int materialId,String treatmentInstruction);
  void updateMaterialRecommendation(int materialId,String recommendation);
  void updateMaterialReferenceImage(int materialId,String referenceImage);
  Material getMaterialById(int materialId);
  Material getMaterialByName(String materialName);
}
