package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.models.Doctor;
import com.hospitalmanagementsystem.Hospital.Management.System.models.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.models.PatientOperationUtils;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@Service
public class DoctorService extends PatientOperationUtils {

    // DependencyInjection
    // When we pass control of object creation from us to springboot or spring
    // We call it as Inversion of control IOC


    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    HospitalService hospitalService;

    public void register(Doctor obj){
        obj.setDocId(UUID.randomUUID());
        Hospital hospital = hospitalService.getHospitalByID(obj.getHospitalId());
        hospital.getDoctors().add(obj);
        doctorRepository.registerDoctor(obj);
    }
    public List<Doctor> getAllDoctor(){
        return doctorRepository.getAllDoctors();
    }
    public Doctor getDoctorById(UUID docId){
        return doctorRepository.getDoctorById(docId);
    }
}