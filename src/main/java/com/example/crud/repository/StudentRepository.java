package com.example.crud.repository;

import com.example.crud.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE LOWER(s.dept) LIKE %?1% OR s.dept LIKE %?1% OR LOWER(s.email) LIKE %?1% OR  s.email LIKE %?1% OR LOWER(s.name) LIKE %?1% OR s.name LIKE %?1% OR CONCAT(s.id, '') LIKE %?1%")
    Page<Student> searchBy(String search, Pageable pageable);
}
