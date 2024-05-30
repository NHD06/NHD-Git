package com.example.qlsv.employ.employservices;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlsv.employ.employmodel.StudentInfo;
import com.example.qlsv.employ.employrepositories.EmployRepository;
//Phương thức triển khai service
@Service
public class EmployServiceImpl implements  EmployService{
    
    @Autowired
    EmployRepository studentRepository; // kết nối tự động với kho

    // các phưuong thức được triển khai từ service
    @Override
    public StudentInfo save(StudentInfo entity) {
        return studentRepository.save(entity);
    }

    @Override
    public List<StudentInfo> saveAll(List<StudentInfo> entities) {
        return (List<StudentInfo>)studentRepository.saveAll(entities);
    }

    @Override
    public Optional<StudentInfo> findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return studentRepository.existsById(id);
    }

    @Override
    public List<StudentInfo> findAll() {
        return (List<StudentInfo>)studentRepository.findAll();
    }

    @Override
    public List<StudentInfo> findAllById(List<String> ids) {
        return (List<StudentInfo>)studentRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return studentRepository.count();
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void delete(StudentInfo entity) {
        studentRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<String> ids) {
        studentRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<StudentInfo> entities) {
        studentRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
    
    @Override
    public List<StudentInfo> findByStudentIdContainingOrFullNameContaining(String studentId, String fullName) {
        return studentRepository.findByStudentIdContainingOrFullNameContaining(studentId, fullName);
    }
}
