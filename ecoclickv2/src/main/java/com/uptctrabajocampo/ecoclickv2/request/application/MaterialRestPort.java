package com.uptctrabajocampo.ecoclickv2.request.application;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;

public interface MaterialRestPort {
  ResponseEntity<MessageRest<List<Material>>> getAllMaterial();
  ResponseEntity<MessageRest<List<Material>>> getAllMaterialByMaterialType(String materialType);
  ResponseEntity<MessageRest<Material>> createMaterial(Material material);
  ResponseEntity<MessageRest<Void>> updateMaterial(Material material);
  ResponseEntity<MessageRest<Void>> updateMaterialName(int materialId,String materialName);
  ResponseEntity<MessageRest<Void>> updateMaterialType(int materialId,String materialType);
  ResponseEntity<MessageRest<Void>> updateMaterialAddress(int materialId,int rating);
  ResponseEntity<MessageRest<Void>> updateMaterialCollectionProcedure(int materialId,String collectionProcedure);
  ResponseEntity<MessageRest<Void>> updateMaterialTreatmentInstruction(int materialId,String treatmentInstruction);
  ResponseEntity<MessageRest<Void>> updateMaterialRecommendation(int materialId,String recommendation);
  ResponseEntity<MessageRest<Void>> updateMaterialReferenceImage(int materialId,String referenceImage);
  ResponseEntity<MessageRest<Material>> getMaterialById(int materialId);
  ResponseEntity<MessageRest<Material>> getMaterialByName(String materialName);
}
