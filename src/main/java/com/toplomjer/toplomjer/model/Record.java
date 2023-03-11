package com.toplomjer.toplomjer.model;

import jakarta.persistence.*;

@Entity
public class Record {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    private int painLevel;

    private int emotionLevel;

    private String text;



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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmotionLevel() {
        return emotionLevel;
    }

    public void setEmotionLevel(int emotionLevel) {
        this.emotionLevel = emotionLevel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
