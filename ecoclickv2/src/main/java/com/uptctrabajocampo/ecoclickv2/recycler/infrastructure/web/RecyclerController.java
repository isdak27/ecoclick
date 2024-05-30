package com.uptctrabajocampo.ecoclickv2.recycler.infrastructure.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uptctrabajocampo.ecoclickv2.exception.MessageRest;
import com.uptctrabajocampo.ecoclickv2.recycler.application.RecyclerService;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;

@Controller
@RestController
@RequestMapping("/api/recyclers")
public class RecyclerController {
    
    @Autowired
    private final RecyclerService recyclerService;

    public RecyclerController(RecyclerService recyclerService) {
        this.recyclerService = recyclerService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<MessageRest<List<Recycler>>> getAllRecyclers() {
        return recyclerService.getAllRecycler();
    }

    @PostMapping("/create")
    public ResponseEntity<MessageRest<Recycler>> createRecycler(@RequestBody Recycler recycler) {
        return recyclerService.createRecycler(recycler);
    }

    @PostMapping("/create/allParams")
    public ResponseEntity<MessageRest<Recycler>> createRecycler(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String documentType,
            @RequestParam String documentNumber,
            @RequestParam Date dateOfBirth,
            @RequestParam String contactNumber,
            @RequestParam String alternativeNumber,
            @RequestParam String email,
            @RequestParam String alternativeEmail) {
        return recyclerService.createRecycler(firstName, lastName, documentType, documentNumber, dateOfBirth, contactNumber, alternativeNumber, email, alternativeEmail);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageRest<Void>> updateRecycler(@RequestBody Recycler recycler) {
        return recyclerService.updateRecycler(recycler);
    }

    @PatchMapping("/update/environmentalLicense")
    public ResponseEntity<MessageRest<Void>> updateRecyclerEnvironmentalLicense(@RequestParam int recyclerId, @RequestParam String environmentalLicense) {
        return recyclerService.updateRecyclerEnvironmentalLicense(recyclerId, environmentalLicense);
    }

    @PatchMapping("/update/email")
    public ResponseEntity<MessageRest<Void>> updateRecyclerEmail(@RequestParam int recyclerId, @RequestParam String email) {
        return recyclerService.updateRecyclerEmail(recyclerId, email);
    }

    @PatchMapping("/update/contactNumber")
    public ResponseEntity<MessageRest<Void>> updateRecyclerContactNumber(@RequestParam int recyclerId, @RequestParam String contactNumber) {
        return recyclerService.updateRecyclerContactNumber(recyclerId, contactNumber);
    }

    @PatchMapping("/update/alternativeNumber")
    public ResponseEntity<MessageRest<Void>> updateRecyclerAlternativeNumber(@RequestParam int recyclerId, @RequestParam String alternativeNumber) {
        return recyclerService.updateRecyclerAlternativeNumber(recyclerId, alternativeNumber);
    }

    @PatchMapping("/update/alternativeEmail")
    public ResponseEntity<MessageRest<Void>> updateRecyclerAlternativeEmail(@RequestParam int recyclerId, @RequestParam String alternativeEmail) {
        return recyclerService.updateRecyclerAlternativeEmail(recyclerId, alternativeEmail);
    }

    @GetMapping("/findByEnvironmentalLicense")
    public  ResponseEntity<MessageRest<Recycler>> getRecyclerByEnvironmentalLicense(@RequestParam String environmentalLicense) {
        return recyclerService.getRecyclerByEnvironmentalLicense(environmentalLicense);
    }

    @GetMapping("/findById")
    public  ResponseEntity<MessageRest<Recycler>> getRecyclerById(@RequestParam int recyclerId) {
        return recyclerService.getRecyclerById(recyclerId);
    }

    @GetMapping("/findByDocumentNumber")
    public  ResponseEntity<MessageRest<Recycler>> getRecyclerByDocumentNumber(@RequestParam String documentNumber) {
        return recyclerService.getRecyclerByDocumentNumber(documentNumber);
    }

    @GetMapping("/findByEmail")
    public  ResponseEntity<MessageRest<Recycler>> getRecyclerByEmail(@RequestParam String email) {
        return recyclerService.getRecyclerByemail(email);
    }
}
