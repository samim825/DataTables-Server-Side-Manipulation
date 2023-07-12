package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;
import com.example.crud.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentServiceImpl studentService;


    @PostMapping
    public Student saveStudent(Student student){

        logger.info("Create student with {}", student.toString());
        return studentService.save(student);

    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @DeleteMapping("/id/{id}")
    public void deleteStudent(Integer id){
        studentService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id){

        return studentService.findById(id);

    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        List<Student> studentList = (List<Student>) studentService.findAll();
        return studentList;
    }

}
