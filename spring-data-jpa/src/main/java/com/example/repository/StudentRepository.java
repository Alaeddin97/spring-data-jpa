package com.example.repository;


import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Transactional
    @Modifying
    @Query(value = "update Student s set s.firstName =?2 where s.email=?1")
    void updateStudentFirstName(String email,String firstName);

}
