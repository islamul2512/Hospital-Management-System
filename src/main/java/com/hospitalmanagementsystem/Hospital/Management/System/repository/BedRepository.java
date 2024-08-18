package com.hospitalmanagementsystem.Hospital.Management.System.repository;

import com.hospitalmanagementsystem.Hospital.Management.System.models.Bed;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class BedRepository {
    HashMap<UUID, Bed> bedDB = new HashMap<>();

    public void addBed(Bed obj){
        UUID id = obj.getBedId();
        bedDB.put(id, obj);
    }

    public List<Bed> getAllBeds(){
        List<Bed> beds = new ArrayList<>();
        for(UUID key : bedDB.keySet()){
            Bed obj = bedDB.get(key);
            beds.add(obj);
        }
        return beds;
    }
    public Bed getBedById(UUID bedId){
        return bedDB.get(bedId);
    }
}