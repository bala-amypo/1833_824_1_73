// AuditLogServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.AuditLogService;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRecordRepository auditLogRepository;

    public AuditLogServiceImpl(AuditLogRecordRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public AuditLogRecord saveLog(AuditLogRecord log) {
        return auditLogRepository.save(log);
    }
}
