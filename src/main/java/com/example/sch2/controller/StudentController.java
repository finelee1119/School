package com.example.sch2.controller;

import com.example.sch2.dto.StudentDto;
import com.example.sch2.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sch2")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentlist")
    public String showStudentListView(Model model) {
        List<StudentDto> studentDtoList = studentService.findAll();
        model.addAttribute("dto", studentDtoList);
        return "student_list";
    }
}
