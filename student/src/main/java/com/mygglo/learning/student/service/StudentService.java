package com.mygglo.learning.student.service;

import com.mygglo.learning.student.domain.Student;
import com.mygglo.learning.student.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by James Kokou GAGLO on 2019-07-01.
 */
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public StudentDto save(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentRepository.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    BeanUtils.copyProperties(student,studentDto);
                    return studentDto;

                })
                .collect(Collectors.toList());
    }

    public StudentDto findById(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    BeanUtils.copyProperties(student,studentDto);
                    return studentDto;
                }).get();
    }
}
