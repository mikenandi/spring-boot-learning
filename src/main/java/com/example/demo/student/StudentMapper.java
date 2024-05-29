package com.example.demo.student;

import com.example.demo.models.Student;
import com.example.demo.models.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstname(studentDto.firstName());
        student.setLastname(studentDto.lastName());
        student.setEmail(studentDto.email());

        School school = new School();
        school.setId(studentDto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponse(Student student) {

        return new StudentResponseDto(
                    student.getId(),
                    student.getFirstname(),
                    student.getLastname(),
                    student.getEmail());
    }
}
