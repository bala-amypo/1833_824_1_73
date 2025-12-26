package com.example.demo.service.impl;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.AuditLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRecordRepository repository;

    public AuditLogServiceImpl(AuditLogRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AuditLogRecord> getLogsByRequestId(Long requestId) {
        return repository.findByRequestId(requestId);
    }
}
