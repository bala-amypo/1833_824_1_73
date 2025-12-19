package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    // Constructor injection
    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate t) {
        // Enforce unique templateName
        Optional<WorkflowTemplate> existing = workflowTemplateRepository.findByTemplateName(t.getTemplateName());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Template name must be unique");
        }

        // Set default values if not provided
        if (t.getActive() == null) t.setActive(true); // default active true
        if (t.getTotalLevels() == null) t.setTotalLevels(1); // default 1 level
        if (t.getDescription() == null) t.setDescription("");

        return workflowTemplateRepository.save(t);
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        return workflowTemplateRepository.findById(id).orElse(null);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        Optional<WorkflowTemplate> optionalTemplate = workflowTemplateRepository.findById(id);
        if (optionalTemplate.isPresent()) {
            WorkflowTemplate existingTemplate = optionalTemplate.get();
            
            // Update fields
            existingTemplate.setTemplateName(t.getTemplateName());
            existingTemplate.setDescription(t.getDescription());
            existingTemplate.setTotalLevels(t.getTotalLevels());
            existingTemplate.setActive(t.getActive());
            
            return workflowTemplateRepository.save(existingTemplate);
        }
        return null; // or throw exception
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        Optional<WorkflowTemplate> optionalTemplate = workflowTemplateRepository.findById(id);
        if (optionalTemplate.isPresent()) {
            WorkflowTemplate template = optionalTemplate.get();
            template.setActive(active); // toggle active flag
            return workflowTemplateRepository.save(template);
        }
        return null; // or throw exception
    }
}
