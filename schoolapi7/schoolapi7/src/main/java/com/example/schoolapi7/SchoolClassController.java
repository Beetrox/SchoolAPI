package com.example.schoolapi7;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class SchoolClassController {

    FileService fileService;
    List<SchoolClass> schoolClasses;

    public SchoolClassController() {
        fileService = new FileService();
        schoolClasses = new ArrayList<>();
//        schoolClasses.add(new SchoolClass(1, "Math", "Tora", "A101", new Date(), new Date()));
    }

    @RequestMapping(value = "/schoolclasses" , method = RequestMethod.GET)
    public List<SchoolClass> getSchoolClasses(@RequestParam(value="searchString", defaultValue = "") String schoolClassSubject) {
        ArrayList<SchoolClass> schoolClasses = fileService.getSchoolClasses();
        ArrayList<SchoolClass> result = new ArrayList<>();
        for (SchoolClass schoolClass : schoolClasses) {
            if(schoolClass.getSubject().contains(schoolClassSubject))
                result.add(schoolClass);
        }
        return result;
    }

    @RequestMapping(value = "/schoolclass/{id}" , method = RequestMethod.GET)
    public SchoolClass getSchoolClass(@PathVariable("id") int id) {
        ArrayList<SchoolClass> schoolClasses = fileService.getSchoolClasses();
        SchoolClass schoolClass = findSchoolClassById(id);
        return schoolClass;
    }

    @RequestMapping(value = "/schoolclass", method = RequestMethod.POST)
    public SchoolClass postSchoolClass(@RequestBody SchoolClass schoolClass) {
        ArrayList<SchoolClass> schoolClasses = fileService.getSchoolClasses();
        if (schoolClass == null) {
            return null;
        }
        schoolClasses.add(schoolClass);
        fileService.saveSchoolClasses(schoolClasses);
        return schoolClass;
    }

    @RequestMapping(value = "/schoolclass/{id}" , method = RequestMethod.PUT)
    public SchoolClass putSchoolClass(@PathVariable("id") int id, @RequestBody SchoolClass schoolClass) {
        ArrayList<SchoolClass> schoolClasses = fileService.getSchoolClasses();
        SchoolClass schoolClass1 = findSchoolClassById(id);
        schoolClasses.remove(schoolClass1);
        schoolClasses.add(schoolClass);

        fileService.saveSchoolClasses(schoolClasses);
        return schoolClass;
    }

    @RequestMapping(value = "/schoolclass/{id}" , method = RequestMethod.DELETE)
    public boolean deleteSchoolClass(@PathVariable("id")int id) {
        ArrayList<SchoolClass> schoolClasses = fileService.getSchoolClasses();
        SchoolClass schoolClass = findSchoolClassById(id);
        if (schoolClass == null) {
            return false;
        }
        schoolClasses.remove(schoolClass);
        fileService.saveSchoolClasses(schoolClasses);
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
