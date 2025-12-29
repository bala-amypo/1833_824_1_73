
// // package com.example.demo.service;

// // import com.example.demo.model.WorkflowStepConfig;
// // import com.example.demo.repository.WorkflowStepConfigRepository;
// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

// //     private final WorkflowStepConfigRepository repository;

// //     public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repository) {
// //         this.repository = repository;
// //     }

// //     @Override
// //     public WorkflowStepConfig createStep(WorkflowStepConfig step) {
// //         return repository.save(step);
// //     }

// //     @Override
// //     public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
// //         return repository.findByTemplateIdOrderByLevelNumberAsc(templateId);
// //     }
// // }
// package com.example.demo.service;

// import com.example.demo.model.WorkflowStepConfig;

// import java.util.List;

// public interface WorkflowStepConfigService {
//     WorkflowStepConfig saveStep(WorkflowStepConfig step);
//     List<WorkflowStepConfig> getStepsForTemplate(Long templateId);
// }
package com.example.demo.service.impl;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository stepRepository;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    @Override
    public WorkflowStepConfig saveStep(WorkflowStepConfig step) {
        return stepRepository.save(step);
    }

    @Override
    public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
        return stepRepository.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}
