package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "tbl_department")
@Table(name = "tbl_department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @SequenceGenerator(
            name = "sequence_department",
            sequenceName = "sequence_department"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_department"
    )
    private Long id;
    private String name;
    @OneToOne(
            mappedBy = "department"
    )
    private Student student;

    public Department(String name) {
        this.name = name;
    }
}



















