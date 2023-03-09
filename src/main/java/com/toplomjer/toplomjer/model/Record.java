package com.toplomjer.toplomjer.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Record {


    @GeneratedValue()
    @Id
    private int id;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    private int painLevel;


    public Record() {

    }

    public Record(Patient patient) {
        this.patient = patient;
        this.painLevel = 0;
    }

    public Record(Patient patient, int painLevel) {
        this.patient = patient;
        this.painLevel = painLevel;

    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }
}
