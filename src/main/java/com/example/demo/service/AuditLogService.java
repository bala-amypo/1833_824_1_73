package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {

    private final AuditLogRecordRepository repository;

    public AuditLogService(AuditLogRecordRepository repository) {
        this.repository = repository;
    }

    public AuditLogRecord save(AuditLogRecord record) {
        return repository.save(record);
    }

    public List<AuditLogRecord> findByRequestId(Long requestId) {
        return repository.findByRequestId(requestId);
    }
}
