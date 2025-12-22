package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService workflowTemplateService;

    public WorkflowTemplateController(WorkflowTemplateService workflowTemplateService) {
        this.workflowTemplateService = workflowTemplateService;
    }

    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate t) {
        return workflowTemplateService.createTemplate(t);
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return workflowTemplateService.getTemplateById(id);
    }

    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return workflowTemplateService.getAllTemplates();
    }

    @PutMapping("/{id}")
    public WorkflowTemplate update(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate t) {
        return workflowTemplateService.updateTemplate(id, t);
    }

    @PatchMapping("/{id}/activate")
    public WorkflowTemplate activate(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return workflowTemplateService.activateTemplate(id, active);
    }
}
