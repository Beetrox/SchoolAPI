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

    //    public List<InventoryItem> getInventoryItems(@RequestParam(value="searchstring", defaultValue = "") String searchString) {
    //
    //        return inventory.getInventory(searchString);
    //    }

    @RequestMapping(value = "/classrooms" , method = RequestMethod.GET)
    public List<Classroom> getSchoolClasses(@RequestParam(value="searchString", defaultValue = "") String classroomName) {
        //filtrera classrooms
        //loopa igenom classrooms
        return classrooms;
    }

}
