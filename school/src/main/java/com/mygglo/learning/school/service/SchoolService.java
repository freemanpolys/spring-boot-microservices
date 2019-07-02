package com.mygglo.learning.school.service;

import com.mygglo.learning.school.domain.School;
import com.mygglo.learning.school.repository.SchoolRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by James Kokou GAGLO on 2019-06-30.
 */
@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolDto save(SchoolDto schoolDto) {
            School school = new School();
        BeanUtils.copyProperties(schoolDto,school);
        schoolRepository.save(school);
        schoolDto.setId(school.getId());
        return schoolDto;
    }

    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }

    public List<SchoolDto> findAll() {
       return schoolRepository.findAll().stream()
               .map(school -> {
                   SchoolDto schoolDto = new SchoolDto();
                   BeanUtils.copyProperties(school,schoolDto);
                   return schoolDto;

               })
                .collect(Collectors.toList());
    }

    public SchoolDto findById(Long id) {
        return schoolRepository.findById(id)
                .map(school -> {
                    SchoolDto schoolDto = new SchoolDto();
                    BeanUtils.copyProperties(school,schoolDto);
                    return schoolDto;
                }).get();
    }

    public String getNameById(Long id) {
        return schoolRepository.getNameById(id);
    }
}
