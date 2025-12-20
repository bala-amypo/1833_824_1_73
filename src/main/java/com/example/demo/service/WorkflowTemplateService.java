package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import java.util.List;

public interface WorkflowTemplateService {

    WorkflowTemplate createTemplate(WorkflowTemplate t);

    WorkflowTemplate getTemplateById(Long id);

    List<WorkflowTemplate> getAllTemplates();

    WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t);

    WorkflowTemplate activateTemplate(Long id, boolean active);
}
