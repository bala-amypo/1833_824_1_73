package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.WorkflowTemplate ;
import com.example.demo.service.AuditTrailRecordService;

@RestController
public class LocationController {

    @Autowired
    WorkflowTemplateService lcs;

    // for post the data
    @PostMapping("/api/templates")
    public Location addLocation(@Valid @RequestBody Location loc) {
        return lcs.createLocation(loc);
    }

    // for get all the data in list view
    @GetMapping
    public List<Location> getAll() {
        return lcs.getAllLocations();
    }

    @GetMapping("/{id}")
    public Location getStudent(@PathVariable Long id) {
        return lcs.getViewByID(id);
    }

    @PutMapping("/{id}")
    public Location updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody Location student) {
        return lcs.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        lcs.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}