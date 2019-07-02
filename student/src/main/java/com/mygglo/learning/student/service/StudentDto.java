package com.mygglo.learning.student.service;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by James Kokou GAGLO on 2019-07-01.
 */
@Data
public class StudentDto {
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private Long schoolId;
    private String schoolName;
    private LocalDateTime creationDate;

}
