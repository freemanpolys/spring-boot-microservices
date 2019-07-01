package com.mygglo.learning.school.service;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by James Kokou GAGLO on 2019-06-30.
 */
@Data
public class SchoolDto {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
