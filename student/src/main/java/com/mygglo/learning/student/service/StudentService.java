package com.mygglo.learning.student.service;

import com.mygglo.learning.student.domain.Student;
import com.mygglo.learning.student.domain.StudentToStudentDtoMapper;
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

    private final StudentToStudentDtoMapper toStudentDtoMapper;

    public StudentService(StudentRepository studentRepository, StudentToStudentDtoMapper toStudentDtoMapper) {
        this.studentRepository = studentRepository;
        this.toStudentDtoMapper = toStudentDtoMapper;
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
                .map(toStudentDtoMapper)
                .collect(Collectors.toList());
    }

    public StudentDto findById(Long id) {
        return studentRepository.findById(id)
                .map(toStudentDtoMapper).get();
    }

}
