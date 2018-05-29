package com.example.schoolapi7;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClassroomController {

    private List<Classroom> classrooms;

    public ClassroomController() {
        classrooms = new ArrayList<Classroom>();
    }

    @RequestMapping(value = "/classrooms" , method = RequestMethod.GET)
    public List<Classroom> getClassrooms(@RequestParam(value="searchString", defaultValue = "") String classroomName) {
        ArrayList<Classroom> result = new ArrayList<>();
        for (Classroom classroom : classrooms ) {
            if(classroom.getName().contains(classroomName))
                result.add(classroom);
        }
        return result;
    }

    @RequestMapping(value = "/classroom/{id}" , method = RequestMethod.GET)
    public Classroom getClassroom(@PathVariable("id") int id) {
        Classroom classroom = findClassroomById(id);
        return classroom;
    }

    @RequestMapping(value = "/classroom", method = RequestMethod.POST)
    public Classroom postClassroom(@RequestBody Classroom classroom) {
        if (classroom == null) {
            return null;
        }
        classrooms.add(classroom);
        return classroom;
    }

    @RequestMapping(value = "/classroom/{id}" , method = RequestMethod.PUT)
    public Classroom putClassroom(@PathVariable("id") int id, @RequestBody Classroom classroom) {
        Classroom classroom1 = findClassroomById(id);
        classrooms.remove(classroom1);
        classrooms.add(classroom);
        return classroom;
    }

    @RequestMapping(value = "/classroom/{id}" , method = RequestMethod.DELETE)
    public boolean deleteClassroom(@PathVariable("id")int id) {
        Classroom classroom = findClassroomById(id);
        if (classroom == null) {
            return false;
        }
        classrooms.remove(classroom);
        return true;
    }

    private Classroom findClassroomById(int id) {
        for (int i = 0; i < classrooms.size(); i++) {
            Classroom classroom = classrooms.get(i);
            if (classroom.getId() == id) {
                return classroom;
            }
        }
        return null;
    }
}
