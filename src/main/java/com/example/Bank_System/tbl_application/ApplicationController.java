package com.example.Bank_System.tbl_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/application")
public class ApplicationController {

    private final ApplicationInterface applicationInterface;

    public ApplicationController( ApplicationInterface applicationInterface) {
        this.applicationInterface = applicationInterface;
    }


    @PostMapping()
    public ApplicationResponse createApplication(@RequestBody CreateApplicationRequest createApplicationRequest) {
        return applicationInterface.createApplication(createApplicationRequest);
    }

    @GetMapping()
    public List<ApplicationResponse> getAllApplications() {
        return applicationInterface.getAllApplications();
    }

    @GetMapping("/{applicationId}")
    public ApplicationResponse getApplicationById(@PathVariable UUID applicationId) {
        return applicationInterface.getApplication(applicationId);
    }

    @DeleteMapping("/{applicationId}")
    public void deleteApplication(@PathVariable UUID applicationId) {
        applicationInterface.deleteApplication(applicationId);
    }

    @PutMapping("/{applicationId}")
    public ApplicationResponse updateApplication(@PathVariable UUID applicationId, @RequestBody UpdateApplicationRequest updateApplicationRequest) {
      return applicationInterface.updateApplication(applicationId, updateApplicationRequest);
    }

}
