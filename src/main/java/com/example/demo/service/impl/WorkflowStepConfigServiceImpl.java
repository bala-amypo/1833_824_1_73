package com.example.demo.service;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository workflowStepConfigRepository;

    public WorkflowStepConfigServiceImpl(
            WorkflowStepConfigRepository workflowStepConfigRepository) {
        this.workflowStepConfigRepository = workflowStepConfigRepository;
    }

    @Override
    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return workflowStepConfigRepository.save(step);
    }

    @Override
    public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
        return workflowStepConfigRepository.findByTemplateId(templateId);
    }
}
