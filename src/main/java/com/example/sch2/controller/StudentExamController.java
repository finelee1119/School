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

        // 각 과목별 총합과 평균 계산
        int totalKor = studentExamService.calculateSubjectTotal(studentList, "kor");
        int totalMath = studentExamService.calculateSubjectTotal(studentList, "math");
        int totalEng = studentExamService.calculateSubjectTotal(studentList, "eng");
        int totalHist = studentExamService.calculateSubjectTotal(studentList, "hist");
        int totalTotalScore = studentExamService.calculateSubjectTotal(studentList, "totalScore");
        double totalAvgScore = studentExamService.calculateSubjectTotal(studentList, "avgScore");

        double avgKor = studentExamService.calculateSubjectAvg(studentList, "kor");
        double avgMath = studentExamService.calculateSubjectAvg(studentList, "math");
        double avgEng = studentExamService.calculateSubjectAvg(studentList, "eng");
        double avgHist = studentExamService.calculateSubjectAvg(studentList, "hist");
        double avgTotalScore = studentExamService.calculateSubjectAvg(studentList, "totalScore");
        double avgAvgScore = studentExamService.calculateSubjectAvg(studentList, "avgScore");

        // 모델에 추가
        model.addAttribute("totalKor", totalKor);
        model.addAttribute("totalMath", totalMath);
        model.addAttribute("totalEng", totalEng);
        model.addAttribute("totalHist", totalHist);
        model.addAttribute("totalTotalScore", totalTotalScore);
        model.addAttribute("totalAvgScore", totalAvgScore);

        model.addAttribute("avgKor", avgKor);
        model.addAttribute("avgMath", avgMath);
        model.addAttribute("avgEng", avgEng);
        model.addAttribute("avgHist", avgHist);
        model.addAttribute("avgTotalScore", avgTotalScore);
        model.addAttribute("avgAvgScore", avgAvgScore);

        return "student_exam_list";
    }
}
