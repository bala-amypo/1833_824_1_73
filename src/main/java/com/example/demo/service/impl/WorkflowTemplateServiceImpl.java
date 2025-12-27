package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

@Service
public class WorkflowTemplateServiceImpl
        implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(
            WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {

        return workflowTemplateRepository
                .findById(id) // returns Optional<WorkflowTemplate>
                .orElseThrow(() ->
                        new RuntimeException("Template not found with id: " + id)
                );
    }
}
