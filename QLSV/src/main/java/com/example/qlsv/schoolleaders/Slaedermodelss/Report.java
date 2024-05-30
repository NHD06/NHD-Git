package com.example.qlsv.schoolleaders.Slaedermodelss;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "school_leaders")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "report_id", length = 50)
    private Long reportId;

    @Column(name = "title", length = 100, columnDefinition = "nvarchar(100)")
    private String title;

    @Column(name = "type", length = 50, columnDefinition = "nvarchar(100)")
    private String type;

    @Column(name = "content", length = 1000, columnDefinition = "nvarchar(100)")
    private String content;

    @Column(name = "for_id", length = 1000)
    private Long forID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_date")
    private Date createdDate;

    public Report() {
    }

    public Report(Long reportId, String title, String type, String content, Long forID, Date createdDate) {
        this.reportId = reportId;
        this.title = title;
        this.type = type;
        this.content = content;
        this.forID = forID;
        this.createdDate = createdDate;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getForID() {
        return forID;
    }

    public void setForID(Long forID) {
        this.forID = forID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }   
}
