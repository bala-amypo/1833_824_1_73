package com.example.demo.controller;

import com.example.demo.entity.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflow-steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService service;

    public WorkflowStepConfigController(WorkflowStepConfigService service) {
        this.service = service;
    }

    @PostMapping
    public WorkflowStepConfig create(@RequestBody WorkflowStepConfig stepConfig) {
        return service.createStep(stepConfig);
    }

    @GetMapping("/{id}")
    public WorkflowStepConfig getById(@PathVariable Long id) {
        return service.getStepById(id);
    }

    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getByTemplate(@PathVariable Long templateId) {
        return service.getStepsByTemplate(templateId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStep(id);
    }
}
