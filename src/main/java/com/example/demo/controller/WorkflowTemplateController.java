package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
@Tag(name = "WorkflowTemplate")
public class WorkflowTemplateController {

    private final WorkflowTemplateService workflowTemplateService;

    public WorkflowTemplateController(
            WorkflowTemplateService workflowTemplateService) {
        this.workflowTemplateService = workflowTemplateService;
    }

    @PostMapping
    @Operation(summary = "Create template")
    public WorkflowTemplate createTemplate(
            @RequestBody WorkflowTemplate template) {
        return workflowTemplateService.createTemplate(template);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get template by id")
    public WorkflowTemplate getTemplateById(@PathVariable Long id) {
        return workflowTemplateService.getTemplateById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update template")
    public WorkflowTemplate updateTemplate(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate template) {
        return workflowTemplateService.updateTemplate(id, template);
    }

    @GetMapping
    @Operation(summary = "List templates")
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateService.getAllTemplates();
    }
}
