package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.WorkflowTemplate ;
import com.example.demo.service.AuditTrailRecordService;

@RestController
public class AuditTrailRecordController {
    @Autowired
    AuditTrailRecordService atrs;

    @PostMapping("/api/templates ")
    public WorkflowTemplate addWorkflowTemplate (@RequestBody AuditTrailRecord atr){
        return atrs.logEvent(atr);
    }

    @GetMapping("/")
    public int first(Long credentialId){
        return atrs.getLogs();
    }

    @GetMapping
    public List<AuditTrailRecord> second(){
        return atrs.getAllLogs();
    }
}