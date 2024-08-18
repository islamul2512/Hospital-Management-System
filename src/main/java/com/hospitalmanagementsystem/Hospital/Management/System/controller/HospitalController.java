package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.models.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//This is going to be a rest api thats why we are writing rest controller
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    // http://localhost:8080/hospital/getAllHospital -> GetMethod
    @GetMapping("/getAllHospital")
    public List<Hospital> getAllHospital(){
        //System.out.println("Inside hospital : ");
        return hospitalService.getAllHospital();
    }

    @PostMapping("/register")
    public String registerHospital(@RequestBody Hospital obj){
        System.out.println(obj);
        hospitalService.registerHospital(obj);
        return "Hospital Added Successfully";
    }

    // 1. If we are not going to use RequestParam then it will be by default optional.
    // either you can pass it or either you cannot pass it
    // 2. If i am going to Use @Requestparam annotation we have to always pass hospitalId
    @GetMapping("")
    public Hospital getHospitalById(@RequestParam UUID hospitalId){
        return hospitalService.getHospitalByID(hospitalId);
    }


}