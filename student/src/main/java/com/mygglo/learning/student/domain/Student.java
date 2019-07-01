package com.mygglo.learning.student.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by James Kokou GAGLO on 2019-07-01.
 */
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private Long schoolId;
    private LocalDateTime creationDate;

    @PrePersist
    public void onPrePersist() {
        creationDate = LocalDateTime.now();
    }

}
