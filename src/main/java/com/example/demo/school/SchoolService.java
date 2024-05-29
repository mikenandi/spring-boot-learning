package com.example.demo.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolResponseDto saveSchool(SchoolDto schoolDto) {
        School school = schoolMapper.toSchool(schoolDto);

        School savedSchool = schoolRepository.save(school);

        return schoolMapper.toSchoolResponseDto(savedSchool);
    }

    public List<SchoolResponseDto> getSchools() {
        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolResponseDto).collect(Collectors.toList());
    }
}
