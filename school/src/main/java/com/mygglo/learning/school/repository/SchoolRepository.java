package com.mygglo.learning.school.repository;

import com.mygglo.learning.school.domain.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by James Kokou GAGLO on 2019-06-30.
 */
@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    @Override
    List<School> findAll();
}
