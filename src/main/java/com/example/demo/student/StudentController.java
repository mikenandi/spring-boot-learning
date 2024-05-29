package com.example.demo.student;

import jakarta.servlet.annotation.HttpConstraint;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
    }

    @GetMapping
    List<StudentResponseDto> getStudents(
            @RequestParam(value = "query", required = false) String query) {
        if (query == null || query.isEmpty()) {
            return studentService.getStudents();
        }else{
            return studentService.getStudentsBasedOnFirstname(query);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StudentResponseDto addNewStudent(@Valid @RequestBody StudentDto studentDto) {
      return  studentService.addNewStudent(studentDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable UUID studentId) {
        studentService.deleteStudent(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable UUID studentId, @RequestBody Student student) {
         studentService.updateStudent(studentId, student);
    }
}
