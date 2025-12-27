// package com.example.demo.service.impl;

// import com.example.demo.model.WorkflowTemplate;
// import com.example.demo.repository.WorkflowTemplateRepository;
// import com.example.demo.service.WorkflowTemplateService;
// import com.example.demo.exception.ResourceNotFoundException;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

//     private final WorkflowTemplateRepository workflowTemplateRepository;

//     public WorkflowTemplateServiceImpl(WorkflowTemplateRepository workflowTemplateRepository) {
//         this.workflowTemplateRepository = workflowTemplateRepository;
//     }

//     @Override
//     public WorkflowTemplate createTemplate(WorkflowTemplate template) {
//         template.setActive(true);
//         return workflowTemplateRepository.save(template);
//     }

//     @Override
//     public Optional<WorkflowTemplate> getTemplateById(Long id) {
//         return workflowTemplateRepository.findById(id);
//     }

//     @Override
//     public List<WorkflowTemplate> getAllTemplates() {
//         return workflowTemplateRepository.findAll();
//     }

//     @Override
//     public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
//         WorkflowTemplate existing = workflowTemplateRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("WorkflowTemplate not found"));

//         existing.setTemplateName(template.getTemplateName());
//         existing.setDescription(template.getDescription());
//         existing.setTotalLevels(template.getTotalLevels());
//         existing.setActive(template.getActive());

//         return workflowTemplateRepository.save(existing);
//     }

//     @Override
//     public WorkflowTemplate activateTemplate(Long id, boolean active) {
//         WorkflowTemplate template = workflowTemplateRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("WorkflowTemplate not found"));
//         template.setActive(active);
//         return workflowTemplateRepository.save(template);
//     }
// }
package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate t) {
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
        WorkflowTemplate existing = repository.findById(id).orElseThrow();
        existing.setTemplateName(t.getTemplateName());
        existing.setDescription(t.getDescription());
        existing.setTotalLevels(t.getTotalLevels());
        existing.setActive(t.getActive());
        return repository.save(existing);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate t = repository.findById(id).orElseThrow();
        t.setActive(active);
        return repository.save(t);
    }
}
