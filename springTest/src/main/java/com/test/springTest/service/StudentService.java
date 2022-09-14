package com.test.springTest.service;

import com.test.springTest.bins.Student;
import com.test.springTest.exception.SchoolSystemException;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(long id) throws SchoolSystemException;
    List<Student> findAllStudents();
    Student findStudentById(long id) throws SchoolSystemException;
    List<Student> findAllStudentsByName(String name);
    double avgScoreStudentById(long id) throws SchoolSystemException;
}
