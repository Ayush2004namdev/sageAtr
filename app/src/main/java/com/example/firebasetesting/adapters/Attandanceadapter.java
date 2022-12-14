package com.example.firebasetesting.adapters;

public class Attandanceadapter {

    private String date,subject,aorp;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAorp() {
        return aorp;
    }

    public void setAorp(String aorp) {
        this.aorp = aorp;
    }

    public Attandanceadapter(String date, String subject, String aorp) {
        this.date = date;
        this.subject = subject;
        this.aorp = aorp;
    }
}
