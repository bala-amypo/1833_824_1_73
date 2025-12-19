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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
@Tag(name = "Workflow Template API", description = "APIs for managing workflow templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    @Operation(summary = "Create workflow template")
    @PostMapping("/")
    public WorkflowTemplate createTemplate(@RequestBody WorkflowTemplate template) {
        return service.createTemplate(template);
    }

    @Operation(summary = "Get workflow template by ID")
    @GetMapping("/{id}")
    public WorkflowTemplate getTemplate(@PathVariable Long id) {
        return service.getTemplateById(id);
    }

    @Operation(summary = "Update workflow template")
    @PutMapping("/{id}")
    public WorkflowTemplate updateTemplate(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate template) {
        return service.updateTemplate(id, template);
    }

    @Operation(summary = "List all workflow templates")
    @GetMapping("/")
    public List<WorkflowTemplate> listTemplates() {
        return service.getAllTemplates();
    }

    @Operation(summary = "Activate or deactivate workflow template")
    @PutMapping("/{id}/activate")
    public WorkflowTemplate activateTemplate(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.activateTemplate(id, active);
    }
}
