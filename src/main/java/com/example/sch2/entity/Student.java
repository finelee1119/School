package com.example.sch2.entity;

import com.example.sch2.constant.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @Column(name="student_no", nullable = false, length = 6)
    private String studentNo;

    @Column(name="name", length = 10)
    private String name;

    @Column(name="phone", length = 15)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="address", length = 20)
    private String address;
}
