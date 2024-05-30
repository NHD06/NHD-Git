package com.example.qlsv.schoolleaders.Slaederrepositories;

import com.example.qlsv.schoolleaders.Slaedermodelss.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
