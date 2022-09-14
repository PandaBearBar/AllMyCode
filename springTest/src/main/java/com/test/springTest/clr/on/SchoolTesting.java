package com.test.springTest.clr.on;

import com.test.springTest.bins.Grade;
import com.test.springTest.bins.Koteret;
import com.test.springTest.bins.Student;
import com.test.springTest.bins.Topic;
import com.test.springTest.controller.StudentController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SchoolTesting implements CommandLineRunner {

    private final String webApi = "http://localhost:8080/students";

    private final RestTemplate restTemplate;


    @Override
    public void run(String... args) throws Exception {


        Student toAdd1 =
                Student.builder()
                        .name("Moshe")
                        .isActive(false)
                        .birthday(Date.valueOf("1999-08-27"))
                        .grade(Grade.builder().topic(Topic.Project1).score(97).build())
                        .grade(Grade.builder().topic(Topic.Project2).score(79).build())
                        .grade(Grade.builder().topic(Topic.Project3).score(88).build())
                        .build();
        Student toAdd2 =
                Student.builder()
                        .name("Roni Ha Melech")
                        .isActive(true)
                        .birthday(Date.valueOf("2002-06-01"))
                        .grade(Grade.builder().topic(Topic.Project1).score(95).build())
                        .grade(Grade.builder().topic(Topic.Project2).score(100).build())
                        .grade(Grade.builder().topic(Topic.Project3).score(100).build())
                        .build();
        System.out.println(Koteret.ADD.getMsg());
        try {
            ResponseEntity<String> res1 = restTemplate.postForEntity(webApi, toAdd1, String.class);
            System.out.println(res1.getStatusCodeValue() == HttpStatus.CREATED.value() ? "Crated" : "Error");
            ResponseEntity<String> res2 = restTemplate.postForEntity(webApi, toAdd2, String.class);
            System.out.println(res2.getStatusCodeValue() == HttpStatus.CREATED.value() ? "Crated" : "Error");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println(Koteret.LIST.getMsg());
        try {
            Student[] students =
                    restTemplate.getForObject(webApi, Student[].class);
            List<Student> studentList =
                    Arrays.stream(students).collect(Collectors.toList());
            System.out.println(studentList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Koteret.UNO.getMsg());
        try {
            Student student =
                    restTemplate.getForObject(webApi + "/1", Student.class);
            System.out.println(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println(Koteret.AVG.getMsg());
        try {
            Double avg =
                    restTemplate.getForObject(webApi + "/avg/2", Double.class);
            System.out.println(avg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println(Koteret.ListByName.getMsg());
        try {
            Student[] students =
                    restTemplate.getForObject(webApi + "/?name=Moshe", Student[].class);
            List<Student> studentList =
                    Arrays.stream(students).collect(Collectors.toList());
            System.out.println(studentList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println(Koteret.DELETE.getMsg());
        try {
            restTemplate.delete(webApi+"/2");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println(Koteret.UNO.getMsg());
        try {
            Student student =
                    restTemplate.getForObject(webApi + "/7777", Student.class);
            System.out.println(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
