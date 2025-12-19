// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PathVariable;


// @RestController
// public class  WorkflowStepConfigController{
//     @Autowired
//     private WorkflowStepConfigService abc;

//     @PostMapping("/api/steps")
//     public WorkflowStepConfig createStep(@RequestBody WorkflowStepConfig xyz) {
//         return abc.save(xyz);
//     }
   
//     @GetMapping("/template/{templated}")
//     public List<WorkflowStepConfig> getStepsForTemplte(@PathVariable Long templated) {
//         return abc.findByStepsForTemplte(templated);

// }