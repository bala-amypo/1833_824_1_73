
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
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_templates", uniqueConstraints = @UniqueConstraint(columnNames = "template_name"))
public class WorkflowTemplateService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_name")
    private String templateName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Integer totalLevels;

    @Column(nullable = false)
    private Boolean active = Boolean.TRUE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalLevels() {
        return totalLevels;
    }

    public void setTotalLevels(Integer totalLevels) {
        this.totalLevels = totalLevels;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
