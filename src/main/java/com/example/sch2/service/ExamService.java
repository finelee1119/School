package com.example.sch2.service;

import com.example.sch2.dto.ExamDto;
import com.example.sch2.entity.Exam;
import com.example.sch2.repository.ExamRepository;
import com.example.sch2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    @Autowired
    public ExamService(ExamRepository examRepository, StudentRepository studentRepository) {
        this.examRepository = examRepository;
    }

    public List<ExamDto> findAll() {
        List<ExamDto> examDtoList = new ArrayList<>();
        examDtoList = examRepository.findAll()
                .stream()
                .map(ExamDto::fromExam)
                .toList();
        return examDtoList;
    }

    public void inputExam(ExamDto examDto) {
        Exam exam = Exam.builder()
                .examNo(examDto.getExamNo())
                .kor(examDto.getKor())
                .math(examDto.getMath())
                .eng(examDto.getEng())
                .hist(examDto.getHist())
                .build();
        examRepository.save(exam);
    }
}
