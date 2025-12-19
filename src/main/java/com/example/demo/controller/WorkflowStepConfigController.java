package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class  WorkflowStepConfigController{
    @Autowired
    private WorkflowStepConfigService abc;

    @PostMapping("/api/steps")
    public WorkflowStepConfig createStep(@RequestBody xyz) {
        return abc.(xyz);
    }
   
    @GetMapping(/template/{templated})
    public List<WorkflowStepConfigService> getStepsForTemplte(Long templated) {
        return abc.findByStepsForTemplte(templated);

}