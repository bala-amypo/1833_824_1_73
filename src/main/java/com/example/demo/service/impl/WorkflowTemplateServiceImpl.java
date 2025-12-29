
// // package com.example.demo.service;

// // import com.example.demo.model.WorkflowTemplate;
// // import com.example.demo.repository.WorkflowTemplateRepository;
// // import org.springframework.stereotype.Service;

// // import java.util.List;
// // import java.util.Optional;

// // @Service
// // public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

// //     private final WorkflowTemplateRepository repository;

// //     public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
// //         this.repository = repository;
// //     }

// //     @Override
// //     public WorkflowTemplate createTemplate(WorkflowTemplate t) {
// //         return repository.save(t);
// //     }

// //     @Override
// //     public Optional<WorkflowTemplate> getTemplateById(Long id) {
// //         return repository.findById(id);
// //     }

// //     @Override
// //     public List<WorkflowTemplate> getAllTemplates() {
// //         return repository.findAll();
// //     }

// //     @Override
// //     public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
// //         WorkflowTemplate existing = repository.findById(id).orElseThrow();
// //         existing.setTemplateName(t.getTemplateName());
// //         existing.setDescription(t.getDescription());
// //         existing.setTotalLevels(t.getTotalLevels());
// //         existing.setActive(t.getActive());
// //         return repository.save(existing);
// //     }

// //     @Override
// //     public WorkflowTemplate activateTemplate(Long id, boolean active) {
// //         WorkflowTemplate t = repository.findById(id).orElseThrow();
// //         t.setActive(active);
// //         return repository.save(t);
// //     }
// // }
// package com.example.demo.service;

// import com.example.demo.model.WorkflowTemplate;

// import java.util.List;
// import java.util.Optional;

// public interface WorkflowTemplateService {
//     WorkflowTemplate createTemplate(WorkflowTemplate template);
//     Optional<WorkflowTemplate> getTemplateById(Long id);
//     WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template);
//     WorkflowTemplate activateTemplate(Long id, boolean active);
//     List<WorkflowTemplate> getAllTemplates();
// }
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
