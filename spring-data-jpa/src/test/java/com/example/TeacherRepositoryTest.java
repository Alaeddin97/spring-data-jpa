package com.example;

import com.example.entity.Course;
import com.example.entity.Teacher;
import com.example.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherCourses(){
        Course course1=Course.builder()
                .title("Java")
                .build();
        Course course2=Course.builder()
                .title("Python")
                .build();
        Teacher teacher=Teacher.builder()
                .firstName("Pascal")
                .lastName("Morin")
                //.courses(List.of(course1,course2))
                .build();
        teacherRepository.save(teacher);

    }

}
