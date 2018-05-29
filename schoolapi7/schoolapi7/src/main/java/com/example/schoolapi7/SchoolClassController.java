package com.example.schoolapi7;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class SchoolClassController {

    List<SchoolClass> schoolClasses;

    public SchoolClassController() {
        schoolClasses = new ArrayList<>();
    }

    @RequestMapping(value = "/schoolclasses" , method = RequestMethod.GET)
    public List<SchoolClass> getSchoolClasses(@RequestParam(value="searchString", defaultValue = "") String schoolClassSubject) {
        ArrayList<SchoolClass> result = new ArrayList<>();
        for (SchoolClass schoolClass : schoolClasses) {
            if(schoolClass.getSubject().contains(schoolClassSubject))
                result.add(schoolClass);
        }
        return result;
    }

    @RequestMapping(value = "/schoolclass/{id}" , method = RequestMethod.GET)
    public SchoolClass getSchoolClass(@PathVariable("id") int id) {
        SchoolClass schoolClass = findSchoolClassById(id);
        return schoolClass;
    }

    @RequestMapping(value = "/schoolclass", method = RequestMethod.POST)
    public SchoolClass postSchoolClass(@RequestBody SchoolClass schoolClass) {
        if (schoolClass == null) {
            return null;
        }
        schoolClasses.add(schoolClass);
        return schoolClass;
    }

    @RequestMapping(value = "/schoolclass/{id}" , method = RequestMethod.PUT)
    public SchoolClass putSchoolClass(@PathVariable("id") int id, @RequestBody SchoolClass schoolClass) {
        SchoolClass schoolClass1 = findSchoolClassById(id);
        schoolClasses.remove(schoolClass1);
        schoolClasses.add(schoolClass);
        return schoolClass;
    }

    @RequestMapping(value = "/schoolclass/{id}" , method = RequestMethod.DELETE)
    public boolean deleteSchoolClass(@PathVariable("id")int id) {
        SchoolClass schoolClass = findSchoolClassById(id);
        if (schoolClass == null) {
            return false;
        }
        schoolClasses.remove(schoolClass);
        return true;
    }

    private SchoolClass findSchoolClassById(int id) {
        for (int i = 0; i < schoolClasses.size(); i++) {
            SchoolClass schoolClass = schoolClasses.get(i);
            if (schoolClass.getId() == id) {
                return schoolClass;
            }
        }
        return null;
    }
}
