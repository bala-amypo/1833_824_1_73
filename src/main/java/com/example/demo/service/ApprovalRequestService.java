package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.model.ApprovalRequestService;

@Service
public interface ApprovalRequestService {
  ApprovalRequestService  createRequest(ApprovalRequestService req);
    getRequestsByRequester(Long UserId);
    getAllRequests();
    
}




