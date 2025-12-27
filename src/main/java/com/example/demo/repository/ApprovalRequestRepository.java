// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.ApprovalRequest;
// import java.util.List;

// public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest, Long> {

//     List<ApprovalRequest> findByRequesterId(Long requesterId);
// }
package com.example.demo.repository;

import com.example.demo.model.ApprovalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest, Long> {
    List<ApprovalRequest> findByRequesterId(Long requesterId);
}
