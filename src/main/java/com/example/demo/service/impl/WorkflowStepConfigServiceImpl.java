package com.example.demo.service.impl;

import com.example.demo.entity.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository repository;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowStepConfig createStep(WorkflowStepConfig stepConfig) {
        return repository.save(stepConfig);
    }

    @Override
    public WorkflowStepConfig getStepById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workflow step not found"));
    }

    @Override
    public List<WorkflowStepConfig> getStepsByTemplate(Long templateId) {
        return repository.findByWorkflowTemplateIdOrderByStepLevelAsc(templateId);
    }

    @Override
    public void deleteStep(Long id) {
        repository.deleteById(id);
    }
}
