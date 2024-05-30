package com.example.qlsv.employ.employmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.qlsv.departmentLeaders.departmentmodelss.Department;


@Entity
@Table(name = "students_info")
public class StudentInfo implements Serializable {
    @Id //xác định đây là khóa chính của bảng
    @Column(name = "student_id", length = 50) // tên và độ dài của cột
    private String studentId;


    @Column(name = "full_name", length = 50)
    private String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "ethnicity", length = 50)
    private String ethnicity;
    
    @Column(name = "religion", length = 50)
    private String religion;
    
    @Column(name = "personal_id", length = 50)
    private String personal_id;
    
    @Column(name = "phone_number", length = 50)
    private String phone_number;
    
    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "course", length = 50)
    private String course;

    @Column(name = "class_department", length = 50)
    private String class_department;

    @ManyToOne // set quản hệ với bảng department
    @JoinColumn(name = "department_id") //cột khóa ngoại
    private Department department;

    public StudentInfo() {
    }

    //phương thức khởi tạo đủ tham số
    public StudentInfo(String studentId, String address, String fullName, Date dateOfBirth,
            boolean gender, String nationality, String ethnicity, String religion, String personal_id,
            String phone_number, String email, String course, String class_department) {
        this.studentId = studentId;
        this.address = address;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.ethnicity = ethnicity;
        this.religion = religion;
        this.personal_id = personal_id;
        this.phone_number = phone_number;
        this.email = email;
        this.course = course;
        this.class_department = class_department;
    }

    //các phương thức set, get
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getClass_department() {
        return class_department;
    }

    public void setClass_department(String class_department) {
        this.class_department = class_department;
    }

       
}
