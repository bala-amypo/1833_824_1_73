package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.WorkflowTemplate ;
import com.example.demo.service.AuditTrailRecordService;

@RestController
public class AuditTrailRecordController {
    @Autowired
    AuditTrailRecordService atrs;

    @PostMapping("/templates ")
    public WorkflowTemplate addWorkflowTemplate (@RequestBody WorkflowTemplate  atr){
        return atrs.createTemplate(atr);
    }

    @GetMapping("/{id}")
    public int first(){
        return atrs.getTemplateById();
    }

    @GetMapping
    public List<AuditTrailRecord> second(){
        return atrs.getAllLogs();
    }
}