package com.example.schoolapi7;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ClassroomController {

    FileService fileService;

    public ClassroomController() {
        fileService = new FileService();
    }

    @RequestMapping(value = "/classrooms" , method = RequestMethod.GET)
    public List<Classroom> getClassrooms(@RequestParam(value="searchString", defaultValue = "") String classroomName) {
        ArrayList<Classroom> classrooms = fileService.getClassrooms();
        ArrayList<Classroom> result = new ArrayList<>();
        for (Classroom classroom : classrooms) {
            if(classroom.getName().contains(classroomName))
                result.add(classroom);
        }
        return result;
    }

    @RequestMapping(value = "/classroom/{id}" , method = RequestMethod.GET)
    public Classroom getClassroom(@PathVariable("id") int id) {
        ArrayList<Classroom> classrooms = fileService.getClassrooms();
        Classroom classroom = findClassroomById(id, classrooms);
        return classroom;
    }

    @RequestMapping(value = "/classroom", method = RequestMethod.POST)
    public Classroom postClassroom(@RequestBody Classroom classroom) {
        ArrayList<Classroom> classrooms = fileService.getClassrooms();
        if (classroom == null) {
            return null;
        }
        classrooms.add(classroom);
        fileService.saveClassrooms(classrooms);
        return classroom;
    }

    @RequestMapping(value = "/classroom/{id}" , method = RequestMethod.PUT)
    public Classroom putClassroom(@PathVariable("id") int id, @RequestBody Classroom classroom) {
        ArrayList<Classroom> classrooms = fileService.getClassrooms();
        Classroom classroom1 = findClassroomById(id, classrooms);
        classrooms.remove(classroom1);
        classrooms.add(classroom);
        fileService.saveClassrooms(classrooms);
        return classroom;
    }

    @RequestMapping(value = "/classroom/{id}" , method = RequestMethod.DELETE)
    public boolean deleteClassroom(@PathVariable("id")int id) {
        ArrayList<Classroom> classrooms = fileService.getClassrooms();
        Classroom classroom = findClassroomById(id, classrooms);
        if (classroom == null) {
            return false;
        }
        classrooms.remove(classroom);
        fileService.saveClassrooms(classrooms);
        return true;
    }

    private Classroom findClassroomById(int id, ArrayList<Classroom> classrooms) {
        for (int i = 0; i < classrooms.size(); i++) {
            Classroom classroom = classrooms.get(i);
            if (classroom.getId() == id) {
                return classroom;
            }
        }
        return null;
    }
}
