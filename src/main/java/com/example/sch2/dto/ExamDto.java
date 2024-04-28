package com.example.sch2.dto;

import com.example.sch2.entity.Exam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamDto {
    private String examNo;
    private int kor;
    private int math;
    private int eng;
    private int hist;

    private int totalScore;
    private double avgScore; // avgScore 필드 추가

    public static ExamDto fromExam(Exam exam) {
        return new ExamDto(
                exam.getExamNo(),
                exam.getKor(),
                exam.getMath(),
                exam.getEng(),
                exam.getHist(),
                0,
                0.0
        );
    }

    public static ExamDto fromExamDto(ExamDto dto) {
        return new ExamDto(
                dto.getExamNo(),
                dto.getKor(),
                dto.getMath(),
                dto.getEng(),
                dto.getHist(),

                dto.getTotalScore(), // 총점을 그대로 가져옴
                dto.getAvgScore()
        );
    }
}
