package com.mygglo.learning.student.repository;

import com.mygglo.learning.student.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by James Kokou GAGLO on 2019-07-01.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Override
    List<Student> findAll();
}
