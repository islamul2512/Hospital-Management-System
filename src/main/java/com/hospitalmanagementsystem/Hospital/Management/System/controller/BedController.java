package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bed")
public class BedController {

    @Autowired
    BedService bedService;

    @PostMapping("/add")
    public void add(@RequestParam UUID hospitalId){
        bedService.addBed(hospitalId);
    }
//    @PostMapping("/add")
//    public void add(@RequestBody UUID hospitalId){
//        bedService.addBed(hospitalId);
//    }
}