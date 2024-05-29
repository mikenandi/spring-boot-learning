package com.example.demo.school;

import com.example.demo.student.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/school")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public SchoolResponseDto create(@RequestBody SchoolDto schoolDto) {
       return schoolService.saveSchool(schoolDto);
     }

     @GetMapping
    public List<SchoolResponseDto> getSchools(){
        return schoolService.getSchools();
     }
}
