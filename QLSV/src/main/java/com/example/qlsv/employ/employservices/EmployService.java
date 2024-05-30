package com.example.qlsv.employ.employservices;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.employ.employmodel.StudentInfo;

//trong service sẽ là các hàm có sẵn để triển khai các phương thức select, edit, delete sinh viên
public interface EmployService {

    StudentInfo save(StudentInfo entity); // Lưu sinh viên

    List<StudentInfo> saveAll(List<StudentInfo> entities); // lưu tất cả

    Optional<StudentInfo> findById(String id); // select sinh viên theo id

    boolean existsById(String id); 

    List<StudentInfo> findAll();

    List<StudentInfo> findAllById(List<String> ids);

    long count();

    void deleteById(String id);

    void delete(StudentInfo entity);

    void deleteAllById(List<String> ids);

    void deleteAll(List<StudentInfo> entities);

    void deleteAll();

    List<StudentInfo> findByStudentIdContainingOrFullNameContaining(String studentId, String fullName); // tìm kiếm sinh viên theo full_name hoặc id
}