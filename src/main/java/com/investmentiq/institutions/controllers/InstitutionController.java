package com.investmentiq.institutions.controllers;

import com.investmentiq.institutions.entities.Institution;
import com.investmentiq.institutions.services.InstitutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.investmentiq.base.globalConstants.Constants.baseUrl;

@RestController
@RequestMapping(baseUrl + "/institution")
public class InstitutionController {

    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrEditInstitution(@RequestBody Institution institution) {
        institutionService.processCreateInstitution(institution);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editInstitution(@RequestBody Institution institution) {
        institutionService.processCreateInstitution(institution);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllInstitutions()
    {
       return ResponseEntity.ok(institutionService.getAllInstitutions());
    }
}
