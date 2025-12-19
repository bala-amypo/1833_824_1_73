// package com.example.demo.controller;

// import jakarta.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.demo.model.WorkflowTemplate;
// import com.example.demo.service.WorkflowTemplateService;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/templates")
// public class WorkflowTemplateController {

//     @Autowired
//     WorkflowTemplateService wts;

//     // for post the data
//     @PostMapping
//     public WorkflowTemplate createTemplate(@Valid @RequestBody WorkflowTemplate template) {
//         return wts.createTemplate(template);
//     }

//     // for get all the data in list view
//     @GetMapping
//     public List<WorkflowTemplate> getAllTemplates() {
//         return wts.getAllTemplates();
//     }

//     @GetMapping("/{id}")
//     public Optional<WorkflowTemplate> getTemplateById(@PathVariable Long id) {
//         return wts.getTemplateById(id);
//     }

//     @PutMapping("/{id}")
//     public WorkflowTemplate updateTemplate(
//             @PathVariable Long id,
//             @Valid @RequestBody WorkflowTemplate template) {
//         return wts.updateTemplate(id, template);
//     }
// }
