package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.model.WorkflowStepConfigService;

@Service
public interface WorkflowStepConfigService  {
   WorkflowStepConfig createStep(WorkFlowStepConfig step);
   WorkflowStepConfig getStepsForTemplte(Long templated);

   
}






