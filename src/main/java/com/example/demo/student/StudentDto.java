package com.example.demo.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record StudentDto(
        @NotEmpty(message = "First name should not be empty")
        String firstName,


        @NotEmpty(message = "last name should not be empty")
        String lastName,

        @NotEmpty(message = "Email should not be empty")
        @Email(message = "should be email")
        String email,

//        @NotEmpty
        UUID schoolId
){}
