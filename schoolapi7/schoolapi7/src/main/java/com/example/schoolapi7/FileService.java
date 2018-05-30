package com.example.schoolapi7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    ObjectMapper objectMapper;

    public FileService() {
        this.objectMapper = new ObjectMapper();
    }

    public ArrayList<Classroom> getClassrooms() {
        //deserialize

        String json = "";

        try {
            URL path = getClass().getClassLoader().getResource("classrooms");
            json = new String(Files.readAllBytes(Paths.get(path.toURI())));
        } catch (IOException e) {
            return null;
        } catch( URISyntaxException e){
            return null;
        }


        ArrayList<Classroom> classrooms;

        try {
            classrooms = objectMapper.readValue(json, new TypeReference<List<Classroom>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return classrooms;
    }

    public void saveClassrooms(ArrayList<Classroom> classrooms) {
        //serialize and save
        String json = null;

        try {
            json = objectMapper.writeValueAsString(classrooms);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            URL path = getClass().getClassLoader().getResource("classrooms");
            Files.write(Paths.get(path.toURI()), json.getBytes());
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        } catch (URISyntaxException e) {

        }
    }

    public ArrayList<SchoolClass> getSchoolClasses() {
        //deserialize

        String json = "";

        try {
            URL path = getClass().getClassLoader().getResource("schoolClasses");
            json = new String(Files.readAllBytes(Paths.get(path.toURI())));
        } catch (IOException e) {
            return null;
        } catch (URISyntaxException e) {
            return null;
        }

        ArrayList<SchoolClass> schoolClasses;

        try {
            schoolClasses = objectMapper.readValue(json, new TypeReference<List<SchoolClass>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return schoolClasses;
    }

    public void saveSchoolClasses(ArrayList<SchoolClass> schoolClasses) {
     //serialize and save
        String json = null;

        try {
            json = objectMapper.writeValueAsString(schoolClasses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            URL path = getClass().getClassLoader().getResource("schoolClasses");
            Files.write(Paths.get(path.toURI()), json.getBytes());
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        } catch (URISyntaxException e) {

        }
    }
}
