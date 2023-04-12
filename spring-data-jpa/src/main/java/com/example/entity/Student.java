package com.example.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "Student")
@Table(
        name = "tbl_student",
        uniqueConstraints = {

                @UniqueConstraint(
                        name = "student_unique_constraint",
                        columnNames = "email"
                )
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "department")
//@ToString
@Builder
public class Student {
    @Id
    @SequenceGenerator(
            name = "sequence_student",
            sequenceName = "sequence_student",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_student"
    )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
    @Embedded
    private Address address;
    @OneToOne(
            cascade = CascadeType.MERGE,
//            fetch = FetchType.EAGER
              fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "id"
    )
    private Department department;


    public Student(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }
}
