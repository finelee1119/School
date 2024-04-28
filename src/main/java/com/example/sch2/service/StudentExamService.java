package com.example.sch2.service;

import com.example.sch2.dto.ExamDto;
import com.example.sch2.dto.StudentDto;
import com.example.sch2.entity.Exam;
import com.example.sch2.entity.Student;
import com.example.sch2.repository.ExamRepository;
import com.example.sch2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentExamService {
    private final ExamRepository examRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentExamService(ExamRepository examRepository, StudentRepository studentRepository) {
        this.examRepository = examRepository;
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findAll() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();

        // ExamDto에 각 과목의 총점을 저장할 변수 추가
        for (Student student : studentList) {
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentNo(student.getStudentNo());
            studentDto.setName(student.getName());

            Exam exam = examRepository.findById(String.valueOf(student.getStudentNo())).orElse(null);
            if (exam != null) {
                ExamDto examDto = new ExamDto();
                examDto.setExamNo(exam.getExamNo());
                examDto.setKor(exam.getKor());
                examDto.setMath(exam.getMath());
                examDto.setEng(exam.getEng());
                examDto.setHist(exam.getHist());
                studentDto.setExamDto(examDto);

                // 개인별 성적 합계
                int totalScore = exam.getKor() + exam.getMath() + exam.getEng() + exam.getHist();
                examDto.setTotalScore(totalScore);

                // 개인별 성적 평균
                double avgScore = totalScore / 4.0;
                examDto.setAvgScore(avgScore);

                // 개인별 석차
                int rank = getRank(examDto, studentList);
                studentDto.setRank(rank);
            }

            studentDtoList.add(studentDto);
        }

        return studentDtoList;
    }

    private int getRank(ExamDto examDto, List<Student> studentList) {
        int rank = 1;
        int totalScore = examDto.getTotalScore();
        for (Student student : studentList) {
            Exam exam = examRepository.findById(String.valueOf(student.getStudentNo())).orElse(null);
            if (exam != null) {
                int otherTotalScore = exam.getKor() + exam.getMath() + exam.getEng() + exam.getHist();
                if (otherTotalScore > totalScore) {
                    rank++;
                }
            }
        }
        return rank;
    }
}
