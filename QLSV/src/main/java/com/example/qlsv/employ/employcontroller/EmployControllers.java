package com.example.qlsv.employ.employcontroller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.qlsv.employ.employmodel.StudentInfo;
import com.example.qlsv.employ.employservices.EmployService;

@Controller
public class EmployControllers {
    @Autowired
    EmployService employService;

    @GetMapping("/")
    public String showAddForm(ModelMap model) {
        StudentInfo student = new StudentInfo();
        model.addAttribute("Employ", student); 
        model.addAttribute("ACTION", "/add");
        return "employ/register-employ";
    }

    // Thêm sinh viên
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("Employ") StudentInfo student) {
        employService.save(student);
        return "redirect:/list";
    }

    // Hiển thị danh sách sinh viên
    @GetMapping("/list")
    public String listStudents(ModelMap model) {
        List<StudentInfo> students = employService.findAll();
        model.addAttribute("students", students);
        return "employ/view-employ";
    }

    // Hiển thị form sửa sinh viên
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, ModelMap model) {
        Optional<StudentInfo> studentOpt = employService.findById(id);
        if (studentOpt.isPresent()) {
            StudentInfo student = studentOpt.get();
            model.addAttribute("Employ", student);
            model.addAttribute("ACTION", "/update/" + id);
            return "employ/register-employ";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") String id, @ModelAttribute("Employ") StudentInfo student) {
        student.setStudentId(id);
        employService.save(student);
        return "redirect:/list";
    }

    // Xóa sinh viên
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        employService.deleteById(id);
        return "redirect:/list";
    }

    //Xem chi tiết sinh viên
    @GetMapping("/desStudent/{id}")
    public String desStudent(@PathVariable("id") String id, ModelMap model) {
        Optional<StudentInfo> studentOptional = employService.findById(id);
        if(studentOptional.isPresent()){
        StudentInfo studentInfo = studentOptional.get();
        model.addAttribute("students", studentInfo);
        model.addAttribute("backUrl", "/list"); 
        return "employ/viewStudent";
        }
        else{
            return "redirect:/list";
        }
    }

}
