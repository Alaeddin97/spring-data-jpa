package com.example.repository;

import com.example.entity.Department;
import net.bytebuddy.TypeCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> findByName(String name, Sort sort);
    Page<Department> findAll(Pageable pageable);
    /*@Query(
            value = "select * from tbl_department as d where d.first_name=?1",
            nativeQuery = true
    )*//*
    @Nullable
    Department findByFirstName(@Nullable String firstName);*/
}
