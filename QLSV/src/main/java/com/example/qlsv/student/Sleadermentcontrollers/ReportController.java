package com.example.qlsv.schoolleaders.Sleadermentcontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.qlsv.employ.employmodel.StudentInfo;
import com.example.qlsv.employ.employservices.EmployService;
import com.example.qlsv.schoolleaders.Slaedermodelss.Report;
import com.example.qlsv.schoolleaders.Slaederservice.ReportService;

@Controller
public class ReportController {
    
    @Autowired
    private ReportService reportService;

    @Autowired
    EmployService employService;

    @GetMapping("/Sleader/list")
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
    @GetMapping("/Sleader/desStudent/{id}")
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
// Báo cáo
    @GetMapping("/reportForm")
    public String showReport(ModelMap model){
        Report report = new Report();
        model.addAttribute("Report", report);
        model.addAttribute("ACTION", "/addReport");
        return "Sleader/reportForm";
    }
    

    @PostMapping("/addReport")
    public String addReport(@ModelAttribute("Report") Report report){
        reportService.save(report);
        return "redirect:/listReport";
    }

    @GetMapping("/listReport")
    public String listReport(ModelMap model){
        List<Report> reports = reportService.findAll();
        model.addAttribute("reports", reports);
        return "Sleader/Report";
    }

    @GetMapping("/editReport/{reportId}")
    public String editReport(@PathVariable("reportId") Long reportId, ModelMap model){
        Optional<Report> reportOptional = reportService.findById(reportId);
        if(reportOptional.isPresent()){
            Report report = reportOptional.get();
            model.addAttribute("Report", report);
            model.addAttribute("ACTION", "/updateReport/" + reportId); // Note the forward slash
            return "Sleader/reportForm";
        }
        else{
            return "redirect:/listReport";
        }
    }

    @PostMapping("/updateReport/{reportId}")
    public String updateReport(@PathVariable("reportId") Long reportId, @ModelAttribute("Report") Report report){
        // Lấy báo cáo từ cơ sở dữ liệu trước khi cập nhật
        Optional<Report> existingReportOptional = reportService.findById(reportId);
        if(existingReportOptional.isPresent()){
            Report existingReport = existingReportOptional.get();
            // Cập nhật các trường của báo cáo hiện tại với các giá trị mới từ form
            existingReport.setTitle(report.getTitle());
            existingReport.setType(report.getType());
            existingReport.setContent(report.getContent());
            existingReport.setForID(report.getForID());
            // Lưu báo cáo đã cập nhật
            reportService.save(existingReport);
        }
        return "redirect:/listReport";
    }

    @GetMapping("/deleteReport/{reportId}")
    public String deleteReport(@PathVariable("reportId") Long reportId){
        reportService.deleteById(reportId);
        return "redirect:/listReport";
    }

}
