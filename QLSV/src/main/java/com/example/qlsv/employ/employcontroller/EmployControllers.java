package com.example.qlsv.employ.employcontroller;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.qlsv.employ.employmodel.StudentInfo;
import com.example.qlsv.employ.employservices.EmployService;

//Lớp điều khiển hệ thống của nhân viên khoa/viện 
@Controller // chú thích đây là controller 
public class EmployControllers {
    @Autowired
    EmployService employService; // kết nối tự động với service

    //hàm trang chủ được chỉ định theo đường dẫn http://localhost:8080/
    @GetMapping("/") // chỉ định dường dẫn
    public String showAddForm(ModelMap model) { // Phương thức trả về giao diện nhập sinh viên
        StudentInfo student = new StudentInfo(); //Tạo một đối tượng sinh viên mới
        model.addAttribute("Employ", student); // thêm phương thức để kết nối với view
        model.addAttribute("ACTION", "/add"); // thêm phương thức để nhận dữ liệu từ form nhập
        return "employ/register-employ"; // trả về trang nhập sinh viên
    }

    // Thêm sinh viên
    @PostMapping("/add") // Phương thức sử lý dũ liệu từ form http://localhost:8080/add
    public String addStudent(@ModelAttribute("Employ") StudentInfo student) {
        employService.save(student); // sử dụng hàm save từ service, tham số là đối tượng sinh viên
        return "redirect:/list"; // trả về trang xem danh sách sinh viên
    }

    // Hiển thị danh sách sinh viên
    // @GetMapping("/list")
    // public String listStudents(ModelMap model) {
    //     List<StudentInfo> students = employService.findAll();
    //     model.addAttribute("students", students);
    //     return "employ/view-employ";
    // }
    @GetMapping("/list") // Phương thức hiển thị danh sách sinh viên
    public String searchStudents(@RequestParam(name = "query", required = false) String query, Model model) {
        List<StudentInfo> searchResults = new ArrayList<>(); // tạo một danh sách sinh viên mưới
        if (query != null && !query.isEmpty()) { // kiểm tra điều kiện tìm kiếm trong thẻ tìm kiếm
            // Search by student ID or full name
            searchResults = employService.findByStudentIdContainingOrFullNameContaining(query, query); // trả về sinh viên có id tương ứng
        } else {
            // If query is empty or null, show all students
            searchResults = employService.findAll(); // trả về sinh viên có tên tương ứng
        }
        
        model.addAttribute("students", searchResults); // tạo phương thức nhận dữ liệu từ form
        return "employ/view-employ"; // trả về view xem danh sách
    }


    // Hiển thị form sửa sinh viên trùng với form nhập
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, ModelMap model) {
        Optional<StudentInfo> studentOpt = employService.findById(id); // sinh viên theo id bằng phương thức fidById từ service
        if (studentOpt.isPresent()) { // check id hợp lệ
            StudentInfo student = studentOpt.get(); // lấy dữ liệu của sinh viên cần sửa
            model.addAttribute("Employ", student); // thêm phương thức kết nối
            model.addAttribute("ACTION", "/update/" + id); // thêm phương thức update sinh viên với dữ liệu mới
            return "employ/register-employ"; // trả về form sửa để bắt đầu sửa
        } else {
            return "redirect:/list"; // id sai sẽ ở lại view danh sách
        }
    }

    //Hàm xử lý update
    @PostMapping("/update/{id}") // đường dẫn http://localhost:8080/update/id . với id đã chọn 
    public String updateStudent(@PathVariable("id") String id, @ModelAttribute("Employ") StudentInfo student) {
        student.setStudentId(id); // nhận dữ liệu từ form
        employService.save(student); // lưu mới sinh viên
        return "redirect:/list"; // trở về trang view
    }

    // Xóa sinh viên
    @GetMapping("/delete/{id}") // đường dẫn http://localhost:8080/delete/id
    public String deleteStudent(@PathVariable("id") String id) {
        employService.deleteById(id); // gọi hàm xóa deleteById từ service với tham số là id của sinh viên đã chọn 
        return "redirect:/list"; // trả về trang view
    }

    //Xem chi tiết sinh viên
    @GetMapping("/desStudent/{id}") // // đường dẫn http://localhost:8080/desStudent/id 
    public String desStudent(@PathVariable("id") String id, ModelMap model) {
        Optional<StudentInfo> studentOptional = employService.findById(id); // tìm kiếm sinh viên có id đã chọn
        if(studentOptional.isPresent()){ // kiểm tra tồn tại
        StudentInfo studentInfo = studentOptional.get(); // lấy sinh viên có id đã chọn
        model.addAttribute("students", studentInfo); 
        model.addAttribute("backUrl", "/list"); // nhấn quay lại trang /list
        return "employ/viewStudent"; // hiển thị trang xem chi tiết
        }
        else{
            return "redirect:/list"; // tìm kiếm id thất bại sẽ ở lại trang /list
        }
    }

}
