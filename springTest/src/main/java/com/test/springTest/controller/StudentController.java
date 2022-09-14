package com.test.springTest.controller;

import com.test.springTest.bins.Student;
import com.test.springTest.exception.SchoolSystemException;
import com.test.springTest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // V
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable long id) throws SchoolSystemException {
        service.deleteStudent(id);
    }
    @GetMapping // V
    public List<Student> getAllStudents(){return service.findAllStudents();}

    @GetMapping("/")// V
    public List<Student> getAllStudentsByName(@RequestParam String name){
        return service.findAllStudentsByName(name);
    }

    @GetMapping("/{id}") // V
    public Student getStudentById(@PathVariable long id) throws SchoolSystemException {return service.findStudentById(id);}

    @GetMapping("/avg/{id}") // V
    public double getAvgScoreStudentById(@PathVariable long id) throws SchoolSystemException {return service.avgScoreStudentById(id);}

}
