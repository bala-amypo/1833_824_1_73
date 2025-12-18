package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.WorkflowTemplate ;
import com.example.demo.service.AuditTrailRecordService;

@RestController
public class LocationController {

    @Autowired
    WorkflowTemplateService lcs;

    // for post the data
    @PostMapping("/api/templates")
    public WorkflowTemplate addWorkflowTemplate(@Valid @RequestBody WorkflowTemplate loc) {
        return lcs.createTemplate(WorkflowTemplate t)(loc);
    }

    // for get all the data in list view
    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return lcs.getAllTemplates();
    }

    @GetMapping("/{id}")
    public Location getWorkflowTemplate(@PathVariable Long id) {
        return lcs. getTemplateById(Long id);
    }

    @PutMapping("/{id}")
    public Location updateTemplate(
            @PathVariable Long id,
            @Valid @RequestBody Location student) {
        return lcs. updateTemplate(Long id,WorkflowTemplat t);
    }

    
}