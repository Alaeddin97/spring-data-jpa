package com.example.entity;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Embeddable
@AttributeOverrides(
        {
                @AttributeOverride(name = "country", column = @Column(name = "student_country")),
                @AttributeOverride(name = "city", column = @Column(name = "student_city")),
                @AttributeOverride(name = "street", column = @Column(name = "student_street")),
                @AttributeOverride(name = "zipCode", column = @Column(name = "student_zip_code"))
        }

)
public class Address {
    private String country;
    private String city;
    private String street;
    private String zipCode;
}
