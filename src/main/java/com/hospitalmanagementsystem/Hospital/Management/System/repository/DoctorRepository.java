package com.hospitalmanagementsystem.Hospital.Management.System.repository;

import com.hospitalmanagementsystem.Hospital.Management.System.models.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class DoctorRepository {

    HashMap<UUID, Doctor> doctorDatabase;

    public DoctorRepository(){
        this.doctorDatabase = new HashMap<>();
    }

    public void registerDoctor(Doctor obj){
        UUID id = obj.getDocId();
        doctorDatabase.put(id, obj);
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = new ArrayList<>();
        for(UUID key : doctorDatabase.keySet()){
            Doctor obj = doctorDatabase.get(key);
            doctors.add(obj);
        }
        return doctors;
    }
    public Doctor getDoctorById(UUID docId){
        return doctorDatabase.get(docId);
    }


}