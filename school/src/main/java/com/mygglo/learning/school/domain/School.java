package com.mygglo.learning.school.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by James Kokou GAGLO on 2019-06-30.
 */
@Entity
@Data
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private LocalDateTime creationDate;

    @PrePersist
    public void onPrePersist() {
        creationDate = LocalDateTime.now();
    }
}
