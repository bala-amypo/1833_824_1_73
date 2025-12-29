package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository templateRepository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        template.setId(null);
        return templateRepository.save(template);
    }

    @Override
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return templateRepository.findById(id);
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        WorkflowTemplate existing = templateRepository.findById(id).orElseThrow();
        existing.setTemplateName(template.getTemplateName());
        existing.setDescription(template.getDescription());
        existing.setTotalLevels(template.getTotalLevels());
        existing.setActive(template.getActive());
        return templateRepository.save(existing);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate existing = templateRepository.findById(id).orElseThrow();
        existing.setActive(active);
        return templateRepository.save(existing);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }
}
