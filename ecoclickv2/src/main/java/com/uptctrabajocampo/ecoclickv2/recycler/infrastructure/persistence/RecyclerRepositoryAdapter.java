package com.uptctrabajocampo.ecoclickv2.recycler.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.RecyclerPort;

@Component
public class RecyclerRepositoryAdapter implements RecyclerPort{
    
    @Autowired
    private final RecyclerRepository recyclerRepository;

    public RecyclerRepositoryAdapter(RecyclerRepository recyclerRepository) {
        this.recyclerRepository = recyclerRepository;
    }

    @Override
    public List<Recycler> getAllRecycler() {
        return recyclerRepository.findAll();
    }

    @Override
    public void createRecycler(Recycler recycler) {
        recyclerRepository.save(recycler);
    }

    @Override
    public void updateRecycler(Recycler recycler) {
        if (recyclerRepository.existsById(recycler.getRecyclerId())) {
            recyclerRepository.save(recycler);
        } else {
            throw new ObjectNotFoundException("Recycler with id " + recycler.getRecyclerId() + " not found");
        }
    }

    @Override
    public void updateRecyclerEnvironmentalLicense(int recyclerId, String environmentalLicense) {
        Optional<Recycler> optionalRecycler = recyclerRepository.findById(recyclerId);
        if (optionalRecycler.isPresent()) {
            Recycler recycler = optionalRecycler.get();
            recycler.setEnvironmentalLicense(environmentalLicense);
            recyclerRepository.save(recycler);
        } else {
            throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
        }
    }

    @Override
    public void updateRecyclerEmail(int recyclerId, String email) {
        Optional<Recycler> optionalRecycler = recyclerRepository.findById(recyclerId);
        if (optionalRecycler.isPresent()) {
            Recycler recycler = optionalRecycler.get();
            recycler.setEmail(email);
            recyclerRepository.save(recycler);
        } else {
            throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
        }
    }

    @Override
    public void updateRecyclerContactNumber(int recyclerId, String contactNumber) {
        Optional<Recycler> optionalRecycler = recyclerRepository.findById(recyclerId);
        if (optionalRecycler.isPresent()) {
            Recycler recycler = optionalRecycler.get();
            recycler.setContactNumber(contactNumber);
            recyclerRepository.save(recycler);
        } else {
            throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
        }
    }

    @Override
    public void updateRecyclerAlternativeNumber(int recyclerId, String alternativeNumber) {
        Optional<Recycler> optionalRecycler = recyclerRepository.findById(recyclerId);
        if (optionalRecycler.isPresent()) {
            Recycler recycler = optionalRecycler.get();
            recycler.setAlternativeNumber(alternativeNumber);
            recyclerRepository.save(recycler);
        } else {
            throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
        }
    }

    @Override
    public void updateRecyclerAlternativeEmail(int recyclerId, String alternativeEmail) {
        Optional<Recycler> optionalRecycler = recyclerRepository.findById(recyclerId);
        if (optionalRecycler.isPresent()) {
            Recycler recycler = optionalRecycler.get();
            recycler.setAlternativeEmail(alternativeEmail);
            recyclerRepository.save(recycler);
        } else {
            throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
        }
    }

    @Override
    public Recycler getRecyclerByEnvironmentalLicense(String environmentalLicense) {
        return recyclerRepository.findByEnvironmentalLicense(environmentalLicense).orElse(null);
    }

    @Override
    public Recycler getRecyclerById(int recyclerId) {
        return recyclerRepository.findById(recyclerId).orElse(null);
    }

    @Override
    public Recycler getRecyclerByDocumentNumber(String documentNumber) {
        return recyclerRepository.findByDocumentNumber(documentNumber).orElse(null);
    }

    @Override
    public Recycler getRecyclerByemail(String email) {
        return recyclerRepository.findByEmail(email).orElse(null);
    }
}
