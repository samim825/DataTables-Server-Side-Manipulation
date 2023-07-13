package com.example.crud.controller;

import com.example.crud.dto.DataTableResponse;
import com.example.crud.model.Student;
import com.example.crud.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public DataTableResponse<Student> getAllStudent(HttpServletRequest request){

        String[] columns = "id,name,email,dept".split(",");

        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        int draw = Integer.parseInt(request.getParameter("draw"));
        String search = request.getParameter("search[value]");


        logger.info(" Start : {} , Length : {} , Draw : {}", start, length, draw);
        logger.info("Search : {}", request.getParameter("search[value]"));
        Sort.Direction direction = request.getParameter("order[0][dir]").equals("asc")? Sort.Direction.ASC : Sort.Direction.DESC ;
        int collIndex = Integer.parseInt(request.getParameter("order[0][column]"));

        Page<Student> studentList;
        Pageable pageable = PageRequest.of(start/length, length, Sort.by(direction,columns[collIndex]));

        if(search.equals("")){

            studentList = (Page<Student>)  studentService.findAll(pageable);
        } else {
            studentList = studentService.searchStudents(search, pageable);
        }
        DataTableResponse<Student> dataTableResponse = new DataTableResponse<>();
        dataTableResponse.setDraw(draw);
        dataTableResponse.setData(studentList.getContent());
        dataTableResponse.setRecordsFiltered(studentList.getTotalElements());
        dataTableResponse.setRecordsFiltered(studentList.getTotalElements());

        return dataTableResponse;
    }


}
