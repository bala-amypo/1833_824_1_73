package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    // 🔹 Constructor as required
    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    // 🔹 Must enforce unique templateName and set defaults
    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate t) {

        if (repository.existsByTemplateName(t.getTemplateName())) {
            throw new RuntimeException("Template name already exists");
        }

        // Default values (important for tests)
        if (t.getActive() == null) {
            t.setActive(true);
        }

        return repository.save(t);
    }

    @Override
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return repository.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        WorkflowTemplate existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        existing.setTemplateName(t.getTemplateName());
        existing.setDescription(t.getDescription());
        existing.setTotalLevels(t.getTotalLevels());

        return repository.save(existing);
    }

    // 🔹 Must toggle active flag and persist
    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        template.setActive(active);
        return repository.save(template);
    }
}
