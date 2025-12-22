package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate t) {
        return workflowTemplateRepository.save(t);
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        return workflowTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkflowTemplate not found"));
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        WorkflowTemplate existing = workflowTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkflowTemplate not found"));

        t.setId(existing.getId());
        return workflowTemplateRepository.save(t);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate wt = workflowTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkflowTemplate not found"));

        wt.setActive(active);
        return workflowTemplateRepository.save(wt);
    }
}
