package com.example.demo.service;

import com.example.demo.entity.WorkflowStepConfig;
import java.util.List;

public interface WorkflowStepConfigService {

    WorkflowStepConfig createStep(WorkflowStepConfig stepConfig);

    WorkflowStepConfig getStepById(Long id);

    List<WorkflowStepConfig> getStepsByTemplate(Long templateId);

    void deleteStep(Long id);
}
