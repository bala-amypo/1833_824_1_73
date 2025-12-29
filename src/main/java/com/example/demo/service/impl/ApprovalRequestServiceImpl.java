
package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository repository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest req) {
        req.setStatus("PENDING");
        return repository.save(req);
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long userId) {
        return repository.findByRequesterId(userId);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return repository.findAll();
    }
}
