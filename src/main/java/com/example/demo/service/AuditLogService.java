
// package com.example.demo.service;

// import org.springframework.stereotype.Service;

// @Service
// public class AuditLogService {

//     public void logAction(String action) {
//         // No implementation needed for tests
//         // This exists only to satisfy UserServiceTest
//     }
// }
package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;

public interface AuditLogService {

    AuditLogRecord saveLog(AuditLogRecord log);
}
