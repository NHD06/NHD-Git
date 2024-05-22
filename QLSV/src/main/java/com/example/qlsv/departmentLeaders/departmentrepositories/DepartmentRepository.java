package com.example.qlsv.departmentLeaders.departmentrepositories;

import org.springframework.data.repository.CrudRepository;

import com.example.qlsv.departmentLeaders.departmentmodelss.Department;

public interface DepartmentRepository extends CrudRepository<Department, String> {
    
}
