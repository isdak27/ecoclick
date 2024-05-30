package com.uptctrabajocampo.ecoclickv2.request.application;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.domain.Load;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;

public interface LoadRestPort {
  ResponseEntity<MessageRest<List<Load>>> getAllLoad();
  ResponseEntity<MessageRest<List<Load>>> getAllLoadByMaterial(Material material);
  ResponseEntity<MessageRest<List<Load>>> getAllLoadByAssociatedPetition(Request associatedPetition);
  ResponseEntity<MessageRest<Load>> createLoad(Load load);
  ResponseEntity<MessageRest<Void>> updateLoad(Load load);
  ResponseEntity<MessageRest<Void>> updateLoadestimateWeight(int loadId,int estimatedWeight);
  ResponseEntity<MessageRest<Void>> updateLoadestimateHeight(int loadId,int estimatedHeight);
  ResponseEntity<MessageRest<Void>> updateLoadestimatedWidth(int loadId,int estimatedWidth);
  ResponseEntity<MessageRest<Void>> updateLoadMaterial(int loadId,Material material);
  ResponseEntity<MessageRest<Void>> updateLoadAssociatedPetition(int loadId,Request associatedPetition);
  ResponseEntity<MessageRest<Void>> updateLoadReferenceImage(int loadId,String referenceImage);
  ResponseEntity<MessageRest<Load>> getLoadById(int loadId);

}
