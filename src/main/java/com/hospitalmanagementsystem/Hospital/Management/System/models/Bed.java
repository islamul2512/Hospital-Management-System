package com.hospitalmanagementsystem.Hospital.Management.System.models;

import java.util.UUID;

public class Bed {
    UUID bedId;
    UUID patient;
    UUID doctor;

    UUID hospitalId;
    boolean isBooked;

    public Bed() {
    }

    public Bed(UUID bedId, UUID patient, UUID doctor, boolean isBooked, UUID hospitalId) {
        this.bedId = bedId;
        this.patient = patient;
        this.doctor = doctor;
        this.isBooked = isBooked;
        this.hospitalId = hospitalId;
    }

    public UUID getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(UUID hospitalId) {
        this.hospitalId = hospitalId;
    }

    public UUID getBedId() {
        return bedId;
    }

    public void setBedId(UUID bedId) {
        this.bedId = bedId;
    }

    public UUID getPatient() {
        return patient;
    }

    public void setPatient(UUID patient) {
        this.patient = patient;
    }

    public UUID getDoctor() {
        return doctor;
    }

    public void setDoctor(UUID doctor) {
        this.doctor = doctor;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}