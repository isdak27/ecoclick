package com.uptctrabajocampo.ecoclickv2.request.domain;

import java.util.List;

public interface LoadPort {
  List<Load> getAllLoad();
  List<Load> getAllLoadByMaterial(Material material);
  List<Load> getAllLoadByAssociatedPetition(Request associatedPetition);
  Load createLoad(Load load);
  void updateLoad(Load load);
  void updateLoadEstimateWeight(int loadId,int estimatedWeight);
  void updateLoadEstimateHeight(int loadId,int estimatedHeight);
  void updateLoadEstimatedWidth(int loadId,int estimatedWidth);
  void updateLoadMaterial(int loadId,Material material);
  void updateLoadAssociatedPetition(int loadId,Request associatedPetition);
  void updateLoadReferenceImage(int loadId,String referenceImage);
  Load getLoadById(int loadId);

}
