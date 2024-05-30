package com.uptctrabajocampo.ecoclickv2.request.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.request.domain.Load;
import com.uptctrabajocampo.ecoclickv2.request.domain.LoadPort;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;

@Service
public class LoadService implements LoadRestPort {

    private final LoadPort loadPort;

    @Autowired
    public LoadService(LoadPort loadPort) {
        this.loadPort = loadPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Load>>> getAllLoad() {
        try {
            List<Load> loads = loadPort.getAllLoad();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), loads), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Load>>> getAllLoadByMaterial(Material material) {
        if (material == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Material", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Load> loads = loadPort.getAllLoadByMaterial(material);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), loads), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<List<Load>>> getAllLoadByAssociatedPetition(Request associatedPetition) {
        if (associatedPetition == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Associated Petition", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            List<Load> loads = loadPort.getAllLoadByAssociatedPetition(associatedPetition);
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), loads), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Load>> createLoad(Load load) {
        if (load == null || load.getMaterial() == null || load.getAssociatedPetition() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load createdLoad = loadPort.createLoad(load);
            return new ResponseEntity<>(new MessageRest<>(1, "Load Created", HttpStatus.CREATED.value(), createdLoad), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLoad(Load load) {
        if (load == null || load.getLoadId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load existingLoad = loadPort.getLoadById(load.getLoadId());
            if (existingLoad != null) {
                loadPort.updateLoad(load);
                return new ResponseEntity<>(new MessageRest<>(1, "Load Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Load Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLoadestimateWeight(int loadId, int estimatedWeight) {
        if (loadId <= 0 || estimatedWeight < 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load existingLoad = loadPort.getLoadById(loadId);
            if (existingLoad != null) {
                loadPort.updateLoadEstimateWeight(loadId, estimatedWeight);
                return new ResponseEntity<>(new MessageRest<>(1, "Load Weight Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Load Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLoadestimateHeight(int loadId, int estimatedHeight) {
        if (loadId <= 0 || estimatedHeight < 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load existingLoad = loadPort.getLoadById(loadId);
            if (existingLoad != null) {
                loadPort.updateLoadEstimateHeight(loadId, estimatedHeight);
                return new ResponseEntity<>(new MessageRest<>(1, "Load Height Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Load Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLoadestimatedWidth(int loadId, int estimatedWidth) {
        if (loadId <= 0 || estimatedWidth < 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load existingLoad = loadPort.getLoadById(loadId);
            if (existingLoad != null) {
                loadPort.updateLoadEstimatedWidth(loadId, estimatedWidth);
                return new ResponseEntity<>(new MessageRest<>(1, "Load Width Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Load Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLoadMaterial(int loadId, Material material) {
        if (loadId <= 0 || material == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load existingLoad = loadPort.getLoadById(loadId);
            if (existingLoad != null) {
                loadPort.updateLoadMaterial(loadId, material);
                return new ResponseEntity<>(new MessageRest<>(1, "Load Material Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Load Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLoadAssociatedPetition(int loadId, Request associatedPetition) {
        if (loadId <= 0 || associatedPetition == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load existingLoad = loadPort.getLoadById(loadId);
            if (existingLoad != null) {
                loadPort.updateLoadAssociatedPetition(loadId, associatedPetition);
                return new ResponseEntity<>(new MessageRest<>(1, "Load Associated Petition Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Load Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateLoadReferenceImage(int loadId, String referenceImage) {
        if (loadId <= 0 || referenceImage == null || referenceImage.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load existingLoad = loadPort.getLoadById(loadId);
            if (existingLoad != null) {
                loadPort.updateLoadReferenceImage(loadId, referenceImage);
                return new ResponseEntity<>(new MessageRest<>(1, "Load Reference Image Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Load Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Load>> getLoadById(int loadId) {
        if (loadId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Load ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Load load = loadPort.getLoadById(loadId);
            if (load != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), load), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Load Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
