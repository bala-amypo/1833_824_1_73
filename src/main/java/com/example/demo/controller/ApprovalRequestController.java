package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "ApprovalRequest")
public class ApprovalRequestController {

    private final ApprovalRequestService approvalRequestService;

    public ApprovalRequestController(ApprovalRequestService approvalRequestService) {
        this.approvalRequestService = approvalRequestService;
    }

    @PostMapping
    @Operation(summary = "Create request")
    public ApprovalRequest createRequest(@RequestBody ApprovalRequest req) {
        return approvalRequestService.createRequest(req);
    }

    @GetMapping
    @Operation(summary = "List requests")
    public List<ApprovalRequest> getAllRequests() {
        return approvalRequestService.getAllRequests();
    }
}
