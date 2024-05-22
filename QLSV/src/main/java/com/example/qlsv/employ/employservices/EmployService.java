package com.example.qlsv.employ.employservices;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.employ.employmodel.StudentInfo;

public interface EmployService {

    StudentInfo save(StudentInfo entity);

    List<StudentInfo> saveAll(List<StudentInfo> entities);

    Optional<StudentInfo> findById(String id);

    boolean existsById(String id);

    List<StudentInfo> findAll();

    List<StudentInfo> findAllById(List<String> ids);

    long count();

    void deleteById(String id);

    void delete(StudentInfo entity);

    void deleteAllById(List<String> ids);

    void deleteAll(List<StudentInfo> entities);

    void deleteAll();

}