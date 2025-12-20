package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService stepService;

    @Autowired
    public WorkflowStepConfigController(WorkflowStepConfigService stepService) {
        this.stepService = stepService;
    }

    // POST: Create a new workflow step
    @PostMapping
    public ResponseEntity<WorkflowStepConfig> createStep(@RequestBody WorkflowStepConfig step) {
        WorkflowStepConfig createdStep = stepService.createStep(step);
        return ResponseEntity.ok(createdStep);
    }

    // GET: List all steps by template ID
    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<WorkflowStepConfig>> getStepsByTemplate(@PathVariable Long templateId) {
        List<WorkflowStepConfig> steps = stepService.getStepsByTemplateId(templateId);
        return ResponseEntity.ok(steps);
    }
}
