package com.learningdto.springbootlearningmoreaboutdtos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate = new Date();
    private String name;
    private String username;
    private String password;
}
