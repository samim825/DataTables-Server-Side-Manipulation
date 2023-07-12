package com.example.crud.service;

import com.example.crud.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student save(Student student);

    Student update(Student student);

    Optional<Student> findById(Integer id);

    void deleteById(Integer id);

    Page<Student> findAll(Pageable pageable);
}
