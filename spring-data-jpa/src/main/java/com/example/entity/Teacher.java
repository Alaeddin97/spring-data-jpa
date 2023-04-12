package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Teacher")
@Table(name = "tbl_teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "sequence_teacher",
            sequenceName = "sequence_teacher",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_teacher"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

 /*   @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course>courses;*/


}




















