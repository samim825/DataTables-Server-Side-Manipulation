package com.example.crud.controller;

import com.example.crud.dto.DataTableResponse;
import com.example.crud.model.Student;
import com.example.crud.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentServiceImpl studentService;


    @GetMapping("/")
    public ModelAndView showHomePage(ModelAndView modelAndView){

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/upsertStudent")
    public ModelAndView showCreateStudentPage(ModelAndView modelAndView, @RequestParam(value = "id", required = false) Integer id){
        Student student = new Student();
        logger.info("Student id : {}", id);
        try{
            if(id != null){
                student = studentService.findById(id).get();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        modelAndView.addObject("student", student);
        modelAndView.setViewName("student");

        return modelAndView;
    }

    @PostMapping("/upsertStudent")
    public ModelAndView updateAndCreateStudent(@ModelAttribute("student") Student student, ModelAndView modelAndView){
        logger.info("Student : {}", student.toString());
        studentService.save(student);
        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }

    @GetMapping("/delete/id/{id}")
    public ModelAndView deleteStudent(@PathVariable("id") Integer id, ModelAndView modelAndView){
        logger.info("id : {}", id);
        studentService.deleteById(id);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
