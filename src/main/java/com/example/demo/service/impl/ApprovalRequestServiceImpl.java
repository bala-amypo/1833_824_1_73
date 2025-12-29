
// // package com.example.demo.service;

// // import com.example.demo.model.ApprovalRequest;
// // import com.example.demo.repository.ApprovalRequestRepository;
// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class ApprovalRequestServiceImpl implements ApprovalRequestService {

// //     private final ApprovalRequestRepository repository;

// //     public ApprovalRequestServiceImpl(ApprovalRequestRepository repository) {
// //         this.repository = repository;
// //     }

// //     @Override
// //     public ApprovalRequest createRequest(ApprovalRequest req) {
// //         req.setStatus("PENDING");
// //         return repository.save(req);
// //     }

// //     @Override
// //     public List<ApprovalRequest> getRequestsByRequester(Long userId) {
// //         return repository.findByRequesterId(userId);
// //     }

// //     @Override
// //     public List<ApprovalRequest> getAllRequests() {
// //         return repository.findAll();
// //     }
// // }
// package com.example.demo.service;

// import com.example.demo.model.ApprovalRequest;

// import java.util.List;

// public interface ApprovalRequestService {
//     ApprovalRequest createRequest(ApprovalRequest request);
//     List<ApprovalRequest> getRequestsByRequester(Long requesterId);
//     List<ApprovalRequest> getAllRequests();
// }
package com.example.demo.service.impl;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository requestRepository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest request) {
        if (request.getStatus() == null) {
            request.setStatus("PENDING");
        }
        return requestRepository.save(request);
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        return requestRepository.findByRequesterId(requesterId);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return requestRepository.findAll();
    }
}
