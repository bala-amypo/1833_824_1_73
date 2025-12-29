
// // package com.example.demo.service;

// // import com.example.demo.model.ApprovalAction;
// // import com.example.demo.repository.ApprovalActionRepository;
// // import org.springframework.stereotype.Service;

// // @Service
// // public class ApprovalActionServiceImpl implements ApprovalActionService {

// //     private final ApprovalActionRepository repository;

// //     public ApprovalActionServiceImpl(ApprovalActionRepository repository) {
// //         this.repository = repository;
// //     }

// //     @Override
// //     public ApprovalAction recordAction(ApprovalAction action) {
// //         return repository.save(action);
// //     }
// // }
// package com.example.demo.service;

// import com.example.demo.model.ApprovalAction;

// import java.util.List;

// public interface ApprovalActionService {
//     ApprovalAction saveAction(ApprovalAction action);
//     List<ApprovalAction> findByLevelAndAction(int levelNumber, String action);
// }
package com.example.demo.service;

import com.example.demo.model.ApprovalAction;

import java.util.List;

public interface ApprovalActionService {
    ApprovalAction saveAction(ApprovalAction action);
    List<ApprovalAction> findByLevelAndAction(int levelNumber, String action);
}
