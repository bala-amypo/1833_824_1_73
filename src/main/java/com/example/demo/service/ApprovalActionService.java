
// package com.example.demo.service;

// import com.example.demo.model.ApprovalAction;

// public interface ApprovalActionService {

//     ApprovalAction recordAction(ApprovalAction action);
// }
package com.example.demo.service;

import com.example.demo.model.ApprovalAction;

import java.util.List;

public interface ApprovalActionService {
    ApprovalAction saveAction(ApprovalAction action);
    List<ApprovalAction> findByLevelAndAction(int levelNumber, String action);
}
