package com.uptctrabajocampo.ecoclickv2.recycler.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.RecyclerPort;

@Service
public class RecyclerService implements RecyclerRestPort {

    @Autowired
    private final RecyclerPort recyclerPort;

    public RecyclerService(RecyclerPort recyclerPort) {
        this.recyclerPort = recyclerPort;
    }

    @Override
    public ResponseEntity<MessageRest<List<Recycler>>> getAllRecycler() {
        try {
            List<Recycler> recyclers = recyclerPort.getAllRecycler();
            return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), recyclers), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Recycler>> createRecycler(Recycler recycler) {
        if (recycler == null || recycler.getDocumentNumber() == null || recycler.getEmail() == null) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            recyclerPort.createRecycler(recycler);
            return new ResponseEntity<>(new MessageRest<>(1, "Recycler Created", HttpStatus.CREATED.value(), recycler), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Recycler>> createRecycler(String firstName, String lastName, String documentType,
            String documentNumber, Date dateOfBirth, String contactNumber, String alternativeNumber, String email,
            String alternativeEmail) {
        Recycler recycler = new Recycler(firstName, lastName, documentType, documentNumber, dateOfBirth, contactNumber, alternativeNumber, email, alternativeEmail);
        return createRecycler(recycler);
    }

    @Override
    public ResponseEntity<MessageRest<Recycler>> createRecycler(String environmentalLicense, String firstName, String lastName,
            String documentType, String documentNumber, Date dateOfBirth, String contactNumber, String alternativeNumber,
            String email, String alternativeEmail) {
        Recycler recycler = new Recycler(environmentalLicense, firstName, lastName, documentType, documentNumber, dateOfBirth, contactNumber, alternativeNumber, email, alternativeEmail);
        return createRecycler(recycler);
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRecycler(Recycler recycler) {
        if (recycler == null || recycler.getRecyclerId() <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Data", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recycler.getRecyclerId());
            if (existingRecycler != null) {
                recyclerPort.updateRecycler(recycler);
                return new ResponseEntity<>(new MessageRest<>(1, "Recycler Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRecyclerEnvironmentalLicense(int recyclerId, String environmentalLicense) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerEnvironmentalLicense(recyclerId, environmentalLicense);
                return new ResponseEntity<>(new MessageRest<>(1, "Recycler Environmental License Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRecyclerEmail(int recyclerId, String email) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerEmail(recyclerId, email);
                return new ResponseEntity<>(new MessageRest<>(1, "Recycler Email Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRecyclerContactNumber(int recyclerId, String contactNumber) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerContactNumber(recyclerId, contactNumber);
                return new ResponseEntity<>(new MessageRest<>(1, "Recycler Contact Number Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRecyclerAlternativeNumber(int recyclerId, String alternativeNumber) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerAlternativeNumber(recyclerId, alternativeNumber);
                return new ResponseEntity<>(new MessageRest<>(1, "Recycler Alternative Number Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Void>> updateRecyclerAlternativeEmail(int recyclerId, String alternativeEmail) {
        try {
            Recycler existingRecycler = recyclerPort.getRecyclerById(recyclerId);
            if (existingRecycler != null) {
                recyclerPort.updateRecyclerAlternativeEmail(recyclerId, alternativeEmail);
                return new ResponseEntity<>(new MessageRest<>(1, "Recycler Alternative Email Updated", HttpStatus.NO_CONTENT.value(), null), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Recycler>> getRecyclerByEnvironmentalLicense(String environmentalLicense) {
        if (environmentalLicense == null || environmentalLicense.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Environmental License", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler recycler = recyclerPort.getRecyclerByEnvironmentalLicense(environmentalLicense);
            if (recycler != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), recycler), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Recycler>> getRecyclerById(int recyclerId) {
        if (recyclerId <= 0) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Recycler ID", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler recycler = recyclerPort.getRecyclerById(recyclerId);
            if (recycler != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), recycler), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Recycler>> getRecyclerByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid Document Number", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        try {
            Recycler recycler = recyclerPort.getRecyclerByDocumentNumber(documentNumber);
            if (recycler != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), recycler), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Recycler Not Found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<MessageRest<Recycler>> getRecyclerByemail(String email) {
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid email", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!email.matches(emailPattern)) {
            return new ResponseEntity<>(new MessageRest<>(0, "Invalid email format", HttpStatus.BAD_REQUEST.value(), null), HttpStatus.BAD_REQUEST);
        }try {
            Recycler recycler = recyclerPort.getRecyclerByemail(email);
            if (recycler != null) {
                return new ResponseEntity<>(new MessageRest<>(1, "Success", HttpStatus.OK.value(), recycler), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageRest<>(0, "Email not found", HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageRest<>(0, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}