package com.example.demo.school;

import com.example.demo.student.Student;

import java.util.UUID;

public record SchoolResponseDto(
        UUID id,
        String name) {}
