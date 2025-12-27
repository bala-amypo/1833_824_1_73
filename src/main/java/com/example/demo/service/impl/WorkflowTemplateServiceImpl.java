package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(
            WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return workflowTemplateRepository.save(template);
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        return workflowTemplateRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Template not found with id: " + id)
                );
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {

        WorkflowTemplate existing = workflowTemplateRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Template not found with id: " + id)
                );

        existing.setName(template.getName());

        return workflowTemplateRepository.save(existing);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }
}
