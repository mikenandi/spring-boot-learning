package com.example.demo.studentProfile;

import com.example.demo.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table
@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String bio;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
