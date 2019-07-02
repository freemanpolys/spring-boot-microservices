package com.mygglo.learning.school.rest;

import com.mygglo.learning.school.service.SchoolDto;
import com.mygglo.learning.school.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by James Kokou GAGLO on 2019-06-30.
 */
@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<SchoolDto>> getAll() {
        return ResponseEntity.ok().body(schoolService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SchoolDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(schoolService.findById(id));
    }
    @GetMapping("/get-name/{id}")
    public ResponseEntity<String> getNameById(@PathVariable Long id) {
        return ResponseEntity.ok().body(schoolService.getNameById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<SchoolDto> create(@RequestBody SchoolDto schoolDto) {
        return ResponseEntity.ok().body( schoolService.save(schoolDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        schoolService.delete(id);
        return ResponseEntity.ok().build();
    }
}
