package com.example.schoolapi7;

import java.util.List;

public class Classroom {

    private String name;
    private List<SchoolClass> schoolClasses;

    public Classroom(String name, List<SchoolClass> schoolClasses) {
        this.name = name;
        this.schoolClasses = schoolClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
}
