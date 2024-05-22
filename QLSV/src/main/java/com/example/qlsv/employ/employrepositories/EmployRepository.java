package com.example.qlsv.employ.employrepositories;

import org.springframework.data.repository.CrudRepository;

import com.example.qlsv.employ.employmodel.StudentInfo;

public interface EmployRepository extends CrudRepository<StudentInfo, String>{
    
}
