package com.example.qlsv.login.controller;
import java.util.List;
import com.example.qlsv.employ.employmodel.StudentInfo;
import com.example.qlsv.employ.employservices.EmployService;
import com.example.qlsv.login.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Chú thích này đển Spring biết đây là Controller
@RequestMapping("/")
public class LoginController {
    //Thêm các dịch vụ 
    @Autowired 
    private UserService userService;

    @Autowired
    EmployService employService;
    
    @RequestMapping("/login")
    public String showLogin(){

        return "login/login";
    }

    //Kiểm tra Login
    @PostMapping("/checkLogin") // Đường dẫn  
    public String checkLogin(ModelMap modelMap, @RequestParam("username")String username, 
    @RequestParam("password")String password, HttpSession session){ //khai báo của phương thức checkLogin với các tham số trong ()
        if(userService.checkLogin(username, password)){ // Kiểm tra phương thức trong Service : Đúng thành công 
            List<StudentInfo> students = employService.findAll(); // Thêm một List Kiểu StudentId để hiển thị khi đăng nhập thành công
            session.setAttribute("USERNAME", username); // Lưu trữ giá trị của username vào session với key là "USERNAME"
            modelMap.addAttribute("Students", students); //Thêm danh sách sinh viên vào modelMap với key là "Students
            return "redirect:/list"; //  chuyển hướng người dùng đến đường dẫn "/list".
        }
        else{
            modelMap.addAttribute("ERROR", "Username or password not exist"); //thêm thông báo lỗi vào modelMap để hiển thị trên giao diện.
            return "login/login"; //rả về trang đăng nhập với thông báo lỗi nếu có
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("USERNAME"); // Loại bỏ thuộc tính có tên "USERNAME" khỏi session. 
        return "login/login"; // Trả về trang đăng nhập sau khi người dùng đã đăng xuất thành công.
    }
}

