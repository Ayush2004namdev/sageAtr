package com.example.firebasetesting.modles;

public class modals {
    public modals() {

    }

    private String Uid;
    private String Name , uname;
    private String Password;
    private String EnrollmentNo;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEnrollmentNo() {
        return EnrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        EnrollmentNo = enrollmentNo;
    }


    public modals(String uid, String mail, String password, String enrollmentNo) {
        Uid = uid;
        Name = mail;
        Password = password;
        EnrollmentNo = enrollmentNo;

    }

    public modals( String mail, String password) {

        Name = mail;
        Password = password;

    }

}
