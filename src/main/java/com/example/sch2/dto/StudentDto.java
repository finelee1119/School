package com.example.sch2.dto;

import com.example.sch2.constant.Gender;
import com.example.sch2.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String studentNo;
    private String name;
    private String phone;
    private Gender gender;
    private String address;
    private ExamDto examDto;
    private int rank; // 석차 추가

    public static StudentDto fromStudent(Student student) {
        return new StudentDto(
                student.getStudentNo(),
                student.getName(),
                student.getPhone(),
                student.getGender(),
                student.getAddress(),
                new ExamDto(),
                1
        );
    }

    public static StudentDto fromStudentDto(StudentDto dto) {
        return new StudentDto(
                dto.getStudentNo(),
                dto.getName(),
                dto.getPhone(),
                dto.getGender(),
                dto.getAddress(),
                dto.getExamDto(),
                dto.getRank()
        );
    }
}
