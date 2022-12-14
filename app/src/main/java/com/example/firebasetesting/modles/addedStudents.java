package com.example.firebasetesting.modles;

public class addedStudents {
    String name,enrollment,course,id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public addedStudents(String name, String enrollment, String course) {
        this.name = name;
        this.enrollment = enrollment;
        this.course = course;
    }
}
