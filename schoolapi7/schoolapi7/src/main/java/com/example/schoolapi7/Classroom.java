package com.example.schoolapi7;

import java.util.List;

public class Classroom {

    private int id;
    private String name;
    private List<SchoolClass> schoolClasses;

    public Classroom(){}

    public Classroom(int id, String name, List<SchoolClass> schoolClasses) {
        this.id = id;
        this.name = name;
        this.schoolClasses = schoolClasses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<SchoolClass> classroomClasses(SchoolClass schoolClass, Classroom classroom) {
        if (schoolClass.getClassroom().equals(classroom.getName())){
            schoolClasses.add(schoolClass);
            return schoolClasses;
        }
        schoolClasses.clear();
        return schoolClasses;
    }
}
