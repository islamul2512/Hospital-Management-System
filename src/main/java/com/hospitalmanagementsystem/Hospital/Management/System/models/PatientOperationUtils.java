package com.hospitalmanagementsystem.Hospital.Management.System.models;

import java.util.List;
import java.util.UUID;

public abstract class PatientOperationUtils {
    public void removePatientFromList(UUID pId, List<Patient> patients){
        for(int i=0; i<patients.size(); i++){
            Patient obj = patients.get(i);
            if(obj.getpId().equals(pId));{
                patients.remove(i);
                break;
            }
        }
    }
}
