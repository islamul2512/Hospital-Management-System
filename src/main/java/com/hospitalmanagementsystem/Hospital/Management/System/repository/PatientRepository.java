package com.hospitalmanagementsystem.Hospital.Management.System.repository;

import com.hospitalmanagementsystem.Hospital.Management.System.models.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class PatientRepository {

    HashMap<UUID, Patient> patientDb = new HashMap();

    public void registerPatient(Patient obj){
        UUID id = obj.getpId();
        patientDb.put(id, obj);
    }

    public Patient getPatientById(UUID id){
        return patientDb.get(id);
    }

    public void updatePatientAdmitStatusToFalse(UUID id){
        patientDb.get(id).setAdmit(false);
    }

}