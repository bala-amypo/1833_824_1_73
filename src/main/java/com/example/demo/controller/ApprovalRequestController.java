// // package com.example.demo.controller;

// // import com.example.demo.model.ApprovalRequest;
// // import com.example.demo.service.ApprovalRequestService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/api/requests")
// // public class ApprovalRequestController {

// //     private final ApprovalRequestService approvalRequestService;

// //     public ApprovalRequestController(ApprovalRequestService approvalRequestService) {
// //         this.approvalRequestService = approvalRequestService;
// //     }

// //     @PostMapping
// //     public ApprovalRequest createRequest(@RequestBody ApprovalRequest request) {
// //         return approvalRequestService.createRequest(request);
// //     }

// //     @GetMapping
// //     public List<ApprovalRequest> getRequests(
// //             @RequestParam(required = false) Long requesterId
// //     ) {
// //         if (requesterId != null) {
// //             return approvalRequestService.getRequestsByRequester(requesterId);
// //         }
// //         return approvalRequestService.getAllRequests();
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.ApprovalRequest;
// import com.example.demo.service.ApprovalRequestService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/requests")
// public class ApprovalRequestController {

//     private final ApprovalRequestService requestService;

//     public ApprovalRequestController(ApprovalRequestService requestService) {
//         this.requestService = requestService;
//     }

//     @PostMapping
//     public ResponseEntity<ApprovalRequest> createRequest(@RequestBody ApprovalRequest request) {
//         ApprovalRequest created = requestService.createRequest(request);
//         return ResponseEntity.ok(created);
//     }

//     @GetMapping
//     public ResponseEntity<List<ApprovalRequest>> listRequests() {
//         return ResponseEntity.ok(requestService.getAllRequests());
//     }

//     @GetMapping("/requester/{requesterId}")
//     public ResponseEntity<List<ApprovalRequest>> listRequestsByRequester(@PathVariable Long requesterId) {
//         return ResponseEntity.ok(requestService.getRequestsByRequester(requesterId));
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService requestService;

    public ApprovalRequestController(ApprovalRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<ApprovalRequest> createRequest(@RequestBody ApprovalRequest request) {
        ApprovalRequest created = requestService.createRequest(request);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ApprovalRequest>> listRequests() {
        return ResponseEntity.ok(requestService.getAllRequests());
    }

    @GetMapping("/requester/{requesterId}")
    public ResponseEntity<List<ApprovalRequest>> listRequestsByRequester(@PathVariable Long requesterId) {
        return ResponseEntity.ok(requestService.getRequestsByRequester(requesterId));
    }
}

