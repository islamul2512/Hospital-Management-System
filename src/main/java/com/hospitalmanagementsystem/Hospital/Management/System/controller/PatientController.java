package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.models.Patient;
import com.hospitalmanagementsystem.Hospital.Management.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/register")
    public String patientRegister(@RequestBody Patient obj){
        patientService.register(obj);
        return "Patient register successfully";
    }
    //http://localhost:8080/patient/aa0bb955-7107-4940-8c70-2b0e5d3e8dbd/details
    @GetMapping("/{pId}/details")
    public Patient getPatientById(@PathVariable UUID pId){
       Patient p=patientService.getPatientById(pId);
        return p;
    }
    @DeleteMapping("/{pId}/remove")
    public String deletePatientById(@PathVariable UUID pId){
        patientService.deletePatientById(pId);
        return "Patient got Deleted";
    }
}