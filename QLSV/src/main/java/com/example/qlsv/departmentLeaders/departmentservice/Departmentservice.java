package com.example.qlsv.departmentLeaders.departmentservice;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.departmentLeaders.departmentmodelss.Department;

public interface Departmentservice {

    Department save(Department entity);

    List<Department> saveAll(List<Department> entities);

    Optional<Department> findById(String id);

    boolean existsById(String id);

    List<Department> findAll();

    List<Department> findAllById(List<String> ids);

    long count();

    void deleteById(String id);

    void delete(Department entity);

    void deleteAllById(List<String> ids);

    void deleteAll(List<Department> entities);

    void deleteAll();
}