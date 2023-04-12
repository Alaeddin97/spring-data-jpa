package com.example;

import com.example.entity.Address;
import com.example.entity.Department;
import com.example.entity.Student;
import com.example.repository.DepartmentRepository;
import com.example.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void save(){
        Address address=new Address(
                "France",
                "Paris",
                "100 Jules Quentin",
                "9200"
        );

        Department department=Department.builder()
                .name("Maths")
                .build();

        Student student = Student.builder()
                .firstName("Jean")
                .lastName("Paul")
                .email("jean.paul@sqli.com")
                .address(address)
                .department(department)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student>students=
                studentRepository.findAll();
        System.out.println("students = " + students);
    }

    @Test
    public void updateStudentFirstName(){
        studentRepository.updateStudentFirstName(
                "jean.paul@sqli.com","Jacques"
        );
    }

}

























