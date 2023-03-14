package com.toplomjer.toplomjer.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Record {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User patient;


    private int painLevel;

    private int emotionLevel;

    private String text;

    private Date date;



    public Record() {

    }

    public Record(User patient, int painLevel, int emotionLevel, String text) {
        this.patient = patient;
        this.painLevel = painLevel;
        this.emotionLevel = emotionLevel;
        this.text = text;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
