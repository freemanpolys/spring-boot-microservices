package com.mygglo.learning.school.service;

import com.mygglo.learning.school.domain.School;
import com.mygglo.learning.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by James Kokou GAGLO on 2019-06-30.
 */
@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School save(School school) {
           return schoolRepository.save(school);
    }

    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }

    public List<School> findAll() {
       return schoolRepository.findAll();
    }
}
