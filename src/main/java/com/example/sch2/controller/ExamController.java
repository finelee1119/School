package com.example.sch2.controller;

import com.example.sch2.dto.ExamDto;
import com.example.sch2.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sch2")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/examinput")
    public String showExamInputView(Model model) {
        model.addAttribute("dto", new ExamDto());
        return "exam_input";
    }

    @PostMapping("/examinput")
    public String examInput(@ModelAttribute("dto") ExamDto examDto) {
        examService.inputExam(examDto);
        return "redirect:/sch2";
    }
}
