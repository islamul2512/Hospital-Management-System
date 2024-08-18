package com.hospitalmanagementsystem.Hospital.Management.System.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Hospital {
    UUID hospitalID;
    String name;
    List<Bed> beds;
    List<Doctor> doctors;
    List<Patient> patients;
    Long contactNumber;
    String email;

    public Hospital(UUID hospitalID, String name, List<Bed> beds, List<Doctor> doctors, List<Patient> patients, Long contactNumber, String email) {
        this.hospitalID = hospitalID;
        this.name = name;
        this.beds = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public UUID getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(UUID hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalID=" + hospitalID +
                ", name='" + name + '\'' +
                ", beds=" + beds +
                ", doctors=" + doctors +
                ", patients=" + patients +
                ", contactNumber=" + contactNumber +
                ", email='" + email + '\'' +
                '}';
    }
}