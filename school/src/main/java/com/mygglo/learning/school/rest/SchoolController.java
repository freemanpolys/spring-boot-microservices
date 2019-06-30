package com.mygglo.learning.school.rest;

import com.mygglo.learning.school.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(schoolService.findAll());
    }
}
