package com.uptctrabajocampo.ecoclickv2.recycler.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.ObjectNotFoundException;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.RecyclerPort;

@Service
public class RecyclerService implements RecyclerRestPort{

    @Autowired
    private final RecyclerPort recyclerPort;

    public RecyclerService(RecyclerPort recyclerPort) {
        this.recyclerPort = recyclerPort;
    }

    @Override
    public ResponseEntity<List<Recycler>> getAllRecycler() {
        try {
            List<Recycler> recyclers = recyclerPort.getAllRecycler();
            return new ResponseEntity<>(recyclers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> createRecycler(Recycler recycler) {
        if (recycler == null || recycler.getDocumentNumber() == null || recycler.getEmail() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            recyclerPort.createRecycler(recycler);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> createRecycler(String firstName, String lastName, String documentType,
            String documentNumber, Date dateOfBirth, String contactNumber, String alternativeNumber, String email,
            String alternativeEmail) {
        Recycler recycler = new Recycler(firstName, lastName, documentType, documentNumber, dateOfBirth, contactNumber, alternativeNumber, email, alternativeEmail);
        return createRecycler(recycler);
    }

    @Override
    public ResponseEntity<Void> createRecycler(String environmentalLicense, String firstName, String lastName,
            String documentType, String documentNumber, Date dateOfBirth, String contactNumber, String alternativeNumber,
            String email, String alternativeEmail) {
        Recycler recycler = new Recycler(environmentalLicense, firstName, lastName, documentType, documentNumber, dateOfBirth, contactNumber, alternativeNumber, email, alternativeEmail);
        return createRecycler(recycler);
    }

    @Override
    public ResponseEntity<Void> updateRecycler(Recycler recycler) {
        if (recycler == null || recycler.getRecyclerId() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recycler.getRecyclerId());
            if (existingRecycler != null) {
                recyclerPort.updateRecycler(recycler);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> updateRecyclerEnvironmentalLicense(int recyclerId, String environmentalLicense) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerEnvironmentalLicense(recyclerId, environmentalLicense);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
            }
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> updateRecyclerEmail(int recyclerId, String email) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerEmail(recyclerId, email);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
            }
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> updateRecyclerContactNumber(int recyclerId, String contactNumber) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerContactNumber(recyclerId, contactNumber);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
            }
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> updateRecyclerAlternativeNumber(int recyclerId, String alternativeNumber) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerAlternativeNumber(recyclerId, alternativeNumber);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
            }
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> updateRecyclerAlternativeEmail(int recyclerId, String alternativeEmail) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerAlternativeEmail(recyclerId, alternativeEmail);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                throw new ObjectNotFoundException("Recycler with id " + recyclerId + " not found");
            }
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Recycler> getRecyclerByEnvironmentalLicense(String environmentalLicense) {
        if (environmentalLicense == null || environmentalLicense.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler recycler = recyclerPort.getRecyclerByEnvironmentalLicense(environmentalLicense);
            if (recycler != null) {
                return new ResponseEntity<>(recycler, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Recycler> getRecyclerById(int recyclerId) {
        if (recyclerId <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler recycler = recyclerPort.getRecyclerById(recyclerId);
            if (recycler != null) {
                return new ResponseEntity<>(recycler, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Recycler> getRecyclerByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler recycler = recyclerPort.getRecyclerByDocumentNumber(documentNumber);
            if (recycler != null) {
                return new ResponseEntity<>(recycler, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Recycler> getRecyclerByemail(String email) {
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler recycler = recyclerPort.getRecyclerByemail(email);
            if (recycler != null) {
                return new ResponseEntity<>(recycler, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
