package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository approvalRequestRepository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository approvalRequestRepository) {
        this.approvalRequestRepository = approvalRequestRepository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest req) {
        return approvalRequestRepository.save(req);
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long userId) {
        return approvalRequestRepository.findByRequesterlid(userId);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return approvalRequestRepository.findAll();
    }
}
