
// // // package com.example.demo.service;

// // // import com.example.demo.model.ApprovalAction;
// // // import com.example.demo.repository.ApprovalActionRepository;
// // // import org.springframework.stereotype.Service;

// // // @Service
// // // public class ApprovalActionServiceImpl implements ApprovalActionService {

// // //     private final ApprovalActionRepository repository;

// // //     public ApprovalActionServiceImpl(ApprovalActionRepository repository) {
// // //         this.repository = repository;
// // //     }

// // //     @Override
// // //     public ApprovalAction recordAction(ApprovalAction action) {
// // //         return repository.save(action);
// // //     }
// // // }
// // package com.example.demo.service;

// // import com.example.demo.model.ApprovalAction;

// // import java.util.List;

// // public interface ApprovalActionService {
// //     ApprovalAction saveAction(ApprovalAction action);
// //     List<ApprovalAction> findByLevelAndAction(int levelNumber, String action);
// // }
// package com.example.demo.service;

// import com.example.demo.model.ApprovalAction;

// import java.util.List;

// public interface ApprovalActionService {
//     ApprovalAction saveAction(ApprovalAction action);
//     List<ApprovalAction> findByLevelAndAction(int levelNumber, String action);
// }
package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository actionRepository;

    public ApprovalActionServiceImpl(ApprovalActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public ApprovalAction saveAction(ApprovalAction action) {
        return actionRepository.save(action);
    }

    @Override
    public List<ApprovalAction> findByLevelAndAction(int levelNumber, String action) {
        return actionRepository.findByLevelAndAction(levelNumber, action);
    }
}
