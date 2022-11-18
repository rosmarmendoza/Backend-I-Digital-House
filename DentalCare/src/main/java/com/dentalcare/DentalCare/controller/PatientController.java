package com.dentalcare.DentalCare.controller;

import com.dentalcare.DentalCare.domain.Patient;
import com.dentalcare.DentalCare.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/new")

    public void createPatient(@RequestBody Patient patient){
        patientService.toSave(patient);
    }


}
