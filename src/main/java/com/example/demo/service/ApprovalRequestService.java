package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.model.ApprovalRequestService;

@Service
public interface ApprovalRequestService {
    ApprovalRequest  createRequest(ApprovalRequestService req);
    ApprovalRequest getRequestsByRequester(Long UserId);
    ApprovalRequest getAllRequests();
    
}




