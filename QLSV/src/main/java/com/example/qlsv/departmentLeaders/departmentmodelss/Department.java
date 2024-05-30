package com.example.qlsv.departmentLeaders.departmentmodelss;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.qlsv.employ.employmodel.StudentInfo;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Chú thích này đển Spring biết đây là Entity
@Table(name = "department_leaders")
public class Department {
    @Id 
    @Column(name = "department_id", length = 50)
    private String departmentId;

    @Column(name = "department_name", length = 50, columnDefinition = "NVARCHAR(50)")
    private String departmentName;

    @Column(name = "recordType", length = 50, columnDefinition = "NVARCHAR(50)")
    private String recordType;

    @Column(name = "reason", length = 50, columnDefinition = "NVARCHAR(50)")
    private String reason;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

    @OneToMany(mappedBy = "department")
    private List<StudentInfo> students;
    public Department() {
    }

    public Department(String departmentId, String departmentName, String recordType, String reason, String date) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.recordType = recordType;
        this.reason = reason;
        this.date = date;
    }



    public List<StudentInfo> retrieveStudents() {
        return students;
    }
    

    public void assignStudents(List<StudentInfo> students) {
        this.students = students;
    }
    

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StudentInfo> getStudents() {
        return students;
    }

    public void setStudents(List<StudentInfo> students) {
        this.students = students;
    }
}
