package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.models.*;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    HospitalService hospitalService;

    @Autowired
    BedService bedService;

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorService doctorService;
    public void register(Patient obj){
        // 1. Generate UUID for the patient
        UUID id = UUID.randomUUID();
        obj.setpId(id);
        // 2. Get Doctor who is handeling minimum number of patient in that particular hospital
        Doctor doctor = hospitalService.getMinimumPatientDoctorInHospital(obj.getHospitalId());
        obj.setDocId(doctor.getDocId());
        doctor.getPatients().add(obj);
        // 3. Get UnOccupied bed
        Bed bed = bedService.getUnOccupiedBedInHospital(obj.getHospitalId());
        obj.setBedId(bed.getBedId());
        // 4. Set status for the bed with the docId and patientId
        bed.setBooked(true);
        bed.setPatient(obj.getBedId());
        bed.setDoctor(doctor.getDocId());
        // 5.Add Patient in Hospital List
        Hospital hospital = hospitalService.getHospitalByID(
                obj.getHospitalId()
        );
        hospital.getPatients().add(obj);
        // 6. save patient to database
        patientRepository.registerPatient(obj);
    }
    public Patient getPatientById(UUID pId){
        return patientRepository.getPatientById(pId);
    }
    public void deletePatientById(UUID pId){
        // 1. we have to make room free
        Patient p = getPatientById(pId);
        UUID bedId = p.getBedId();
        Bed bed = bedService.getBedById(bedId);
        bed.setPatient(null);
        bed.setDoctor(null);
        bed.setBooked(false);

        // 2. we have to remove patient from doctor list
        UUID docId = p.getDocId();
        Doctor doc = doctorService.getDoctorById(docId);
        List<Patient> patients = doc.getPatients();
        doctorService.removePatientFromList(pId,patients);
        // 3. we have to remove patient from hospital
        Hospital h = hospitalService.getHospitalByID(p.getHospitalId());
        hospitalService.removePatientFromList(pId,h.getPatients());
    }
}