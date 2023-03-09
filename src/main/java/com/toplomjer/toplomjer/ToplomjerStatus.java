package com.toplomjer.toplomjer;

public class ToplomjerStatus {

    private int bol;
   private int radost;
    private int strah;
    private int ljutnja;
   private int tuga;
    private String opisStanja;


    public int getBol() {
        return bol;
    }

    public void setBol(int bol) {
        this.bol = bol;
    }

    public int getRadost() {
        return radost;
    }

    public void setRadost(int radost) {
        this.radost = radost;
    }

    public int getStrah() {
        return strah;
    }

    public void setStrah(int strah) {
        this.strah = strah;
    }

    public int getLjutnja() {
        return ljutnja;
    }

    public void setLjutnja(int ljutnja) {
        this.ljutnja = ljutnja;
    }

    public int getTuga() {
        return tuga;
    }

    public void setTuga(int tuga) {
        this.tuga = tuga;
    }

    public String getOpisStanja() {
        return opisStanja;
    }

    public void setOpisStanja(String opisStanja) {
        this.opisStanja = opisStanja;
    }

    public ToplomjerStatus(int bol, int radost, int strah, int ljutnja, int tuga, String opisStanja) {
        this.bol = bol;
        this.radost = radost;
        this.strah = strah;
        this.ljutnja = ljutnja;
        this.tuga = tuga;
        this.opisStanja = opisStanja;
    }






}
