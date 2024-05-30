package com.example.qlsv.departmentLeaders.departmentservice;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlsv.departmentLeaders.departmentmodelss.Department;
import com.example.qlsv.departmentLeaders.departmentrepositories.DepartmentRepository;

@Service
public class DepartmentserviceImpl implements Departmentservice{
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department  save(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public List<Department> saveAll(List<Department> entities) {
        return (List<Department>)departmentRepository.saveAll(entities);
    }

    @Override
    public Optional<Department> findById(String id) {
        return departmentRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return departmentRepository.existsById(id);
    }

    @Override
    public List<Department> findAll() {
        return (List<Department>)departmentRepository.findAll();
    }

    @Override
    public List<Department> findAllById(List<String> ids) {
        return (List<Department>)departmentRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return departmentRepository.count();
    }

    @Override
    public void deleteById(String id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void delete(Department entity) {
        departmentRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<String> ids) {
        departmentRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<Department> entities) {
        departmentRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        departmentRepository.deleteAll();
    }
    
}
