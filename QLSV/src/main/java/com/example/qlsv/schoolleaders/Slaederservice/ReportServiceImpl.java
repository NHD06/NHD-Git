package com.example.qlsv.schoolleaders.Slaederservice;
import com.example.qlsv.schoolleaders.Slaedermodelss.Report;
import com.example.qlsv.schoolleaders.Slaederrepositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService{
    
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report save(Report entity) {
        return reportRepository.save(entity);
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> findAllById(List<Long> ids) {
        return reportRepository.findAllById(ids);
    }

    @Override
    public Optional<Report> findById(Long id) {
        return reportRepository.findById(id);
    }


    @Override
    public boolean existsById(Long id) {
        return reportRepository.existsById(id);
    }

    @Override
    public long count() {
        return reportRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public void delete(Report entity) {
        reportRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        reportRepository.deleteAll();
    }

    @Override
    public Optional<Report> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {
        
    }
}

