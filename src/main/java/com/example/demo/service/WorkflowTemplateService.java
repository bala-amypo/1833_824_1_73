package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.WorkflowTemplateService ;

@Service
public interface WorkflowTemplateService  {
   WorkflowTemplate  createTemplate(WorkflowTemplate t);
    WorkflowTemplate getTemplateById(Long id);
    WorkflowTemplate getAllTemplates();
    WorkflowTemplate updateTemplate(Long id,WorkflowTemplat t);
    WorkflowTemplate activateTemplate(Long id,boolean active);
   
}






