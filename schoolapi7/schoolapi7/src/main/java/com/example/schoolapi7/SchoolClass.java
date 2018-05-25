package com.example.schoolapi7;

import java.util.Date;

public class SchoolClass {

    private String subject;
    private String teacher;
    private String classroom;
    private Date startingTime;
    private Date endTime;

    public SchoolClass(String subject, String teacher, String classroom, Date startingTime, Date endTime) {
        this.subject = subject;
        this.teacher = teacher;
        this.classroom = classroom;
        this.startingTime = startingTime;
        this.endTime = endTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
