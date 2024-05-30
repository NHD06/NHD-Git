package com.example.qlsv.employ.employrepositories;

import org.springframework.data.repository.CrudRepository;

import com.example.qlsv.employ.employmodel.StudentInfo;
import java.util.List;

//tạo một kho để lưu dữ liệu khi select ở CSDL : QLSV
public interface EmployRepository extends CrudRepository<StudentInfo, String>{
    List<StudentInfo> findByStudentIdContainingOrFullNameContaining(String studentId, String fullName); // tạo một kiểu dữ liệu danh sách để lưu tất cả sinh viên
}
