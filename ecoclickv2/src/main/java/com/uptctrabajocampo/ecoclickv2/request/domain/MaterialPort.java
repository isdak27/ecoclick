package com.uptctrabajocampo.ecoclickv2.request.domain;

import java.util.List;

public interface MaterialPort {
  List<Material> getAllMaterial();
  List<Material> getAllMaterialByMaterialType(String materialType);
  Material createMaterial(Material material);
  void updateMaterial(Material material);
  void updateMaterialName(int materialId,String materialName);
  void updateMaterialType(int materialId,String materialType);
  void updateMaterialAddress(int materialId,int rating);
  void updateMaterialCollectionProcedure(int materialId,int collectionProcedure);
  void updateMaterialTreatmentInstruction(int materialId,int treatmentInstruction);
  Material getMaterialById(int materialId);
  Material getMaterialByName(String materialName);
    
}
