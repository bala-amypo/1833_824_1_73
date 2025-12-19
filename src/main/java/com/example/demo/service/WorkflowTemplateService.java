package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.WorkflowTemplateService ;

@Service
public class WorkflowTemplateService  {
    createTemplate(WorkflowTemplate t);
    getTemplateById(Long id);
    getAllTemplates();
    updateTemplate(Long id,WorkflowTemplat t);
    activateTemplate(Long id,boolean active);
   
}






