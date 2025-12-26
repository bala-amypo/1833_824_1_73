package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService workflowStepConfigService;

    public WorkflowStepConfigController(WorkflowStepConfigService workflowStepConfigService) {
        this.workflowStepConfigService = workflowStepConfigService;
    }

    // POST /api/steps
    @PostMapping
    public ResponseEntity<WorkflowStepConfig> createStep(
            @RequestBody WorkflowStepConfig step) {

        return ResponseEntity.ok(
                workflowStepConfigService.createStep(step)
        );
    }

    // GET /api/steps/template/{templateId}
    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<WorkflowStepConfig>> getStepsByTemplate(
            @PathVariable Long templateId) {

        return ResponseEntity.ok(
                workflowStepConfigService.getStepsForTemplate(templateId)
        );
    }
}
