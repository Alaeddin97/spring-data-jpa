package com.example;

import com.example.entity.*;
import com.example.repository.CourseRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.Optional;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void saveCourses(){

        Optional<Teacher> teacher=teacherRepository.findById(6L);
        Teacher teacher1=Teacher.builder()
                .firstName("Jacques")
                .lastName("Honvault")
                .build();
        Course course=Course.builder()
                .title("Algorithm")
                .teacher(teacher.get())
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudent(){
        Address address=Address.builder()
                .city("Paris")
                .country("France")
                .street("12 Boulvard de l hôpital")
                .zipCode("75 013")
                .build();
        Department department=departmentRepository.findById(1L).get();
        Student student=Student.builder()
                .firstName("Cedric")
                .lastName("Vilani")
                .department(department)
                .email("cedric.vilani@gmail.com")
                .address(address)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("Grigori")
                .lastName("Perlman")
                .build();
        Course course=Course.builder()
                .title("Topology")
                .teacher(teacher)
                .build();
        course.addStudent(student);
        courseRepository.save(course);

    }


}
