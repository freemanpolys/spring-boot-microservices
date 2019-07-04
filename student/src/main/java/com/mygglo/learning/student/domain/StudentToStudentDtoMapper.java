package com.mygglo.learning.student.domain;

import com.mygglo.learning.student.service.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

/**
 * Created by James Kokou GAGLO on 2019-07-01.
 */
@Component
@Slf4j
public class StudentToStudentDtoMapper implements Function<Student, StudentDto> {

    private final RestTemplate restTemplate;

    public StudentToStudentDtoMapper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public StudentDto apply(Student student) {
        StudentDto studentDto = new StudentDto();
        log.info("==========mapper ===" + student);
        BeanUtils.copyProperties(student,studentDto);
        String schoolName = restTemplate.getForObject("http://school-api/get-name/"+student.getSchoolId(), String.class);
        studentDto.setSchoolName(schoolName);
        return studentDto;
    }
}
