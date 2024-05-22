package com.example.qlsv.departmentLeaders.departmentcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.qlsv.departmentLeaders.departmentmodelss.Department;
import com.example.qlsv.departmentLeaders.departmentservice.Departmentservice;
import com.example.qlsv.employ.employmodel.StudentInfo;
import com.example.qlsv.employ.employservices.EmployService;
@Controller
public class departmentController {
    
    @Autowired
    Departmentservice departmentservice;

    @Autowired
    EmployService employService;

    //Xem danh sách sinh viên
    @GetMapping("/department/list")
    public String listStudents(ModelMap model) {
        List<StudentInfo> students = employService.findAll();
        model.addAttribute("students", students);
        return "department/view-department";
    }

    // Xem chi tiết sinh viên
    @GetMapping("/department/desStudent/{id}")
    public String departmentDesStudent(@PathVariable("id") String id, ModelMap model) {
        Optional<StudentInfo> studentOptional = employService.findById(id);
        if(studentOptional.isPresent()){
            StudentInfo studentInfo = studentOptional.get();
            model.addAttribute("students", studentInfo);
            model.addAttribute("backDesStudent", "/list");
            return "department/departmentView";
        }
        else{
            return "redirect:/desStudent/list";
        }
    }
}
