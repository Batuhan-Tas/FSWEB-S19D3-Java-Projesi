package com.workintech.S19D2.service;

import com.workintech.S19D2.entity.Student;
import com.workintech.S19D2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student delete(String tckn) {
        Optional<Student> foundStudent = studentRepository.findStudentByTckn(tckn);
        if(foundStudent.isPresent()){
           studentRepository.delete(foundStudent.get());
           return foundStudent.get();
        }

        System.out.println("No such student.");
        return null;

    }
}
