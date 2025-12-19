package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    @Autowired
    private WorkflowTemplateRepository workflowTemplateRepository;

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate t) {
        // Save new template to DB
        return workflowTemplateRepository.save(t);
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        // Fetch template by id
        Optional<WorkflowTemplate> optionalTemplate = workflowTemplateRepository.findById(id);
        return optionalTemplate.orElse(null); // return null if not found
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        // Fetch all templates
        return workflowTemplateRepository.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        Optional<WorkflowTemplate> optionalTemplate = workflowTemplateRepository.findById(id);
        if(optionalTemplate.isPresent()) {
            WorkflowTemplate existingTemplate = optionalTemplate.get();
            existingTemplate.setTemplateName(t.getTemplateName());
            existingTemplate.setDescription(t.getDescription());
            existingTemplate.setTotalLevels(t.getTotalLevels());
            existingTemplate.setActive(t.getActive());
            return workflowTemplateRepository.save(existingTemplate);
        }
        return null; // or throw exception if template not found
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        Optional<WorkflowTemplate> optionalTemplate = workflowTemplateRepository.findById(id);
        if(optionalTemplate.isPresent()) {
            WorkflowTemplate template = optionalTemplate.get();
            template.setActive(active);
            return workflowTemplateRepository.save(template);
        }
        return null; // or throw exception
    }
}
