package com.workintech.S19D2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="student",schema="security")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="tckn")
    private String tckn;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
}
