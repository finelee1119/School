package com.example.sch2.service;

import com.example.sch2.dto.StudentDto;
import com.example.sch2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findAll() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentDtoList = studentRepository.findAll()
                .stream()
                .map(StudentDto::fromStudent)
                .toList();
        return studentDtoList;
    }
}
