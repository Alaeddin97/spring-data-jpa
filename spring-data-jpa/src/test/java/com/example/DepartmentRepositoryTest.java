package com.example;

import com.example.entity.Department;
import com.example.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DepartmentRepositoryTest {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void findAll(){
       /* Sort.TypedSort<Department> departmentTypedSort = Sort.sort(Department.class);
        Sort sort = departmentTypedSort.by(Department::getId).descending();*/

        List<Department> departmentList = departmentRepository.
                findByName("Maths", Sort.by("id").descending());
        System.out.println("departmentList = " + departmentList);
    }

    @Test
    public void printAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        System.out.println("departments = " + departments);
    }

    @Test
    public void printAllDepartmentsPaged(){
       /* Page<Department> departmentPage = departmentRepository.findAll(Pageable.ofSize(2));
        System.out.println("departmentPage = " + departmentPage.stream().toList());*/
        Page<Department> departmentPage = departmentRepository.findAll(
                PageRequest.of(0,2,Sort.by("id").descending()));
        System.out.println("departmentPage = " + departmentPage.stream().toList());
    }

    /*@Test
    public void printDepartmentsByFirstName(){
        Department department = departmentRepository.findByFirstName("");
        System.out.println("departments = " + department);
    }*/
}
