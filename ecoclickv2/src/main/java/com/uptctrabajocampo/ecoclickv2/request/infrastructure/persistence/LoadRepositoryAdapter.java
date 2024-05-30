package com.uptctrabajocampo.ecoclickv2.request.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.request.domain.Load;
import com.uptctrabajocampo.ecoclickv2.request.domain.LoadPort;
import com.uptctrabajocampo.ecoclickv2.request.domain.Material;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;

@Component
public class LoadRepositoryAdapter implements LoadPort {

    private final LoadRepository loadRepository;

    public LoadRepositoryAdapter(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    @Override
    public List<Load> getAllLoad() {
        return loadRepository.findAll();
    }

    @Override
    public List<Load> getAllLoadByMaterial(Material material) {
        return loadRepository.findAllByMaterial(material);
    }

    @Override
    public List<Load> getAllLoadByAssociatedPetition(Request associatedPetition) {
        return loadRepository.findAllByAssociatedPetition(associatedPetition);
    }

    @Override
    public Load createLoad(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public void updateLoad(Load load) {
        if (loadRepository.existsById(load.getLoadId())) {
            loadRepository.save(load);
        } else {
            throw new ObjectNotFoundException("Load with id " + load.getLoadId() + " not found");
        }
    }

    @Override
    public void updateLoadEstimateWeight(int loadId, int estimatedWeight) {
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        if (optionalLoad.isPresent()) {
            Load load = optionalLoad.get();
            load.setEstimatedWeight(estimatedWeight);
            loadRepository.save(load);
        } else {
            throw new ObjectNotFoundException("Load with id " + loadId + " not found");
        }
    }

    @Override
    public void updateLoadEstimateHeight(int loadId, int estimatedHeight) {
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        if (optionalLoad.isPresent()) {
            Load load = optionalLoad.get();
            load.setEstimatedHeight(estimatedHeight);
            loadRepository.save(load);
        } else {
            throw new ObjectNotFoundException("Load with id " + loadId + " not found");
        }
    }

    @Override
    public void updateLoadEstimatedWidth(int loadId, int estimatedWidth) {
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        if (optionalLoad.isPresent()) {
            Load load = optionalLoad.get();
            load.setEstimatedWidth(estimatedWidth);
            loadRepository.save(load);
        } else {
            throw new ObjectNotFoundException("Load with id " + loadId + " not found");
        }
    }

    @Override
    public void updateLoadMaterial(int loadId, Material material) {
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        if (optionalLoad.isPresent()) {
            Load load = optionalLoad.get();
            load.setMaterial(material);
            loadRepository.save(load);
        } else {
            throw new ObjectNotFoundException("Load with id " + loadId + " not found");
        }
    }

    @Override
    public void updateLoadAssociatedPetition(int loadId, Request associatedPetition) {
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        if (optionalLoad.isPresent()) {
            Load load = optionalLoad.get();
            load.setAssociatedPetition(associatedPetition);
            loadRepository.save(load);
        } else {
            throw new ObjectNotFoundException("Load with id " + loadId + " not found");
        }
    }

    @Override
    public void updateLoadReferenceImage(int loadId, String referenceImage) {
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        if (optionalLoad.isPresent()) {
            Load load = optionalLoad.get();
            load.setReferenceImage(referenceImage);
            loadRepository.save(load);
        } else {
            throw new ObjectNotFoundException("Load with id " + loadId + " not found");
        }
    }

    @Override
    public Load getLoadById(int loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }
}
