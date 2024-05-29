package com.example.demo.student;

import com.example.demo.models.Student;
import com.example.demo.school.SchoolRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final SchoolRepository schoolRepository;


    public StudentService(
            StudentRepository studentRepository,
            StudentMapper studentMapper,
            SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.schoolRepository = schoolRepository;
    }

    List<StudentResponseDto> getStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toStudentResponse).collect(Collectors.toList());
    }

    public StudentResponseDto addNewStudent(StudentDto studentDto) {
        Student student = studentMapper.toStudent(studentDto);

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        boolean isSchoolExist = schoolRepository.existsById(studentDto.schoolId());

        if (!isSchoolExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "School does not exist");
        }

        if (studentByEmail.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponse(savedStudent);
    }

    public void deleteStudent(UUID studentId) {
        boolean exits = studentRepository.existsById(studentId);

        if (!exits) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id " + studentId + " does not exist");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(UUID studentId, Student student) {
        Student studentData = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student with id " + studentId + " does not exist"));

    }

    public List<StudentResponseDto> getStudentsBasedOnFirstname(String query) {
        return studentRepository.findByFirstnameContaining(query).stream()
                .map(studentMapper::toStudentResponse)
                .collect(Collectors.toList());
    }
}
