package com.test.springTest.service;

import com.test.springTest.bins.Grade;
import com.test.springTest.bins.Student;
import com.test.springTest.exception.ExceptionMSG;
import com.test.springTest.exception.SchoolSystemException;
import com.test.springTest.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) throws SchoolSystemException {
        if (!studentRepository.existsById(id))
            throw new SchoolSystemException(ExceptionMSG.IdNotExist);
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(long id) throws SchoolSystemException {
        if (!studentRepository.existsById(id))
            throw new SchoolSystemException(ExceptionMSG.IdNotExist);
        return studentRepository.getReferenceById(id);
    }

    @Override
    public List<Student> findAllStudentsByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public double avgScoreStudentById(long id) throws SchoolSystemException {
        if (!studentRepository.existsById(id))
            throw new SchoolSystemException(ExceptionMSG.IdNotExist);
        List<Grade> gradeList = studentRepository.getReferenceById(id).getGrades();
        int grade =0;
        for (Grade g : gradeList ) {
            grade +=  g.getScore();
        }
        double avg = ((double) grade)/gradeList.size();

        return avg ;
    }
}
