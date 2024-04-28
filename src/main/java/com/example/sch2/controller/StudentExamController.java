package com.example.sch2.controller;

import com.example.sch2.dto.StudentDto;
import com.example.sch2.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sch2")
public class StudentExamController {
    private final StudentExamService studentExamService;

    @Autowired
    public StudentExamController(StudentExamService studentExamService) {
        this.studentExamService = studentExamService;
    }

    @GetMapping("/studentexam")
    public String showStudentExamView(Model model) {
        List<StudentDto> studentList = studentExamService.findAll();
        model.addAttribute("dto", studentList);
        return "student_exam_list";
    }
}
