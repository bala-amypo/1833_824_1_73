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
        Optional<WorkflowTemplate> opt = workflowTemplateRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        t.setId(id);
        return workflowTemplateRepository.save(t);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        Optional<WorkflowTemplate> opt = workflowTemplateRepository.findById(id);
        if (opt.isPresent()) {
            WorkflowTemplate wt = opt.get();
            wt.setActive(active);
            return workflowTemplateRepository.save(wt);
        }
        return null;
    }
}
