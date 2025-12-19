package com.example.demo.service.impl;

import com.example.demo.entity.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return repository.save(template);
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkflowTemplate not found"));
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return repository.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        WorkflowTemplate existing = getTemplateById(id);
        existing.setName(template.getName());
        existing.setDescription(template.getDescription());
        existing.setActive(template.isActive());
        return repository.save(existing);
    }

    @Override
    public void deleteTemplate(Long id) {
        repository.deleteById(id);
    }
}
