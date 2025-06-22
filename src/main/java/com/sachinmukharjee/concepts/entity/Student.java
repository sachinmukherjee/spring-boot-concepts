package com.sachinmukharjee.concepts.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Auditable {

    @Id
    @Column(name = "id",updatable = false,insertable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private String course;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "student")
    private StudentIdCard studentIdCard;

}
