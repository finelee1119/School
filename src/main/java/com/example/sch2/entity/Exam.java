package com.example.sch2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {
    @Id
    @Column(name="exam_no", nullable = false, length = 6)
    private String examNo;

    @Column(name="kor", length = 10)
    private int kor;

    @Column(name="math", length = 15)
    private int math;

    @Column(name="eng", length = 4)
    private int eng;

    @Column(name="hist", length = 20)
    private int hist;
}
