package com.example.qlsv.schoolleaders.Slaederservice;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.schoolleaders.Slaedermodelss.Report;

public interface ReportService {

    Report save(Report entity);

    List<Report> saveAll(List<Report> entities);

    List<Report> findAll();

    List<Report> findAllById(List<Long> ids);

    Optional<Report> findById(Long id);

    boolean existsById(Long id);

    long count();

    void deleteById(Long id);

    void delete(Report entity);

    void deleteAll(List<Report> entities);

    void deleteAll();

    void deleteById(String id);
    
    Optional<Report> findById(String id);


}