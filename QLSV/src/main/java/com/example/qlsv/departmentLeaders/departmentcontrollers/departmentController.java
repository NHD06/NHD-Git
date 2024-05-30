package com.example.qlsv.departmentLeaders.departmentcontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.qlsv.departmentLeaders.departmentservice.Departmentservice;
import com.example.qlsv.employ.employmodel.StudentInfo;
import com.example.qlsv.employ.employservices.EmployService;

@Controller
public class DepartmentController {

    @Autowired
    Departmentservice departmentService;

    @Autowired
    EmployService employService;

    // Xem danh sách sinh viên
    @GetMapping("/department/list")
    public String searchStudents(@RequestParam(name = "query", required = false) String query, Model model) {
        List<StudentInfo> searchResults = new ArrayList<>();
        if (query != null && !query.isEmpty()) {
            // Tìm kiếm theo mã sinh viên hoặc tên đầy đủ
            searchResults = employService.findByStudentIdContainingOrFullNameContaining(query, query);
        } else {
            // Nếu query rỗng hoặc null, hiển thị tất cả sinh viên
            searchResults = employService.findAll();
        }
        
        model.addAttribute("students", searchResults);
        return "department/view-department";
    }

    // Xem chi tiết sinh viên
    @GetMapping("/department/desStudent/{id}")
    public String departmentDesStudent(@PathVariable("id") String id, ModelMap model) {
        Optional<StudentInfo> studentOptional = employService.findById(id);
        if(studentOptional.isPresent()){
            StudentInfo studentInfo = studentOptional.get();
            model.addAttribute("student", studentInfo);
            model.addAttribute("backDepartment", "/department/list"); 
            return "department/departmentView";
        } else {
            return "redirect:/department/list"; // Chuyển hướng đến trang danh sách sinh viên của phòng ban
        }
    }
    
}
