package com.workintech.S19D2.controller;

import com.workintech.S19D2.entity.Student;
import com.workintech.S19D2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping("/")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student student, @PathVariable int id){
       Student foundStudent = findById(id);
       if(foundStudent != null){
           student.setId(id);
           return studentService.save(student);
       }
        return null;
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable String tckn){
        return studentService.delete(tckn);
    }



}
