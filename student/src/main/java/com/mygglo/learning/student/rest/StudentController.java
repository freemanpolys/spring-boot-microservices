package com.mygglo.learning.student.rest;

import com.mygglo.learning.student.service.StudentDto;
import com.mygglo.learning.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by James Kokou GAGLO on 2019-07-01.
 */
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(studentService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok().body( studentService.save(studentDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
