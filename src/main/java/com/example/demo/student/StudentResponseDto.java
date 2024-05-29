package com.example.demo.student;

import java.util.UUID;

public record StudentResponseDto(
        UUID id,
        String firstName,
        String lastName,
        String email) {}
