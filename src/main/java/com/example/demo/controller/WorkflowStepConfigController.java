// package com.example.demo.controller;

// import com.example.demo.model.WorkflowStepConfig;
// import com.example.demo.service.WorkflowStepConfigService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/steps")
// public class WorkflowStepConfigController {

//     private final WorkflowStepConfigService workflowStepConfigService;

//     public WorkflowStepConfigController(WorkflowStepConfigService workflowStepConfigService) {
//         this.workflowStepConfigService = workflowStepConfigService;
//     }

//     @PostMapping
//     public WorkflowStepConfig createStep(@RequestBody WorkflowStepConfig step) {
//         return workflowStepConfigService.createStep(step);
//     }

//     @GetMapping("/template/{templateId}")
//     public List<WorkflowStepConfig> getStepsByTemplate(@PathVariable Long templateId) {
//         return workflowStepConfigService.getStepsForTemplate(templateId);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService stepService;

    public WorkflowStepConfigController(WorkflowStepConfigService stepService) {
        this.stepService = stepService;
    }

    @PostMapping
    public ResponseEntity<WorkflowStepConfig> createStep(@RequestBody WorkflowStepConfig step) {
        WorkflowStepConfig created = stepService.saveStep(step);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<WorkflowStepConfig>> listStepsForTemplate(@PathVariable Long templateId) {
        List<WorkflowStepConfig> steps = stepService.getStepsForTemplate(templateId);
        return ResponseEntity.ok(steps);
    }
}
