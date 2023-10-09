package com.workintech.S19D2.service;

import com.workintech.S19D2.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    Student save(Student student);
    Student delete(String tckn);
}
