package com.example.Bank_System.tbl_application;

import java.util.List;
import java.util.UUID;

public interface ApplicationInterface {
    ApplicationResponse createApplication(CreateApplicationRequest createApplicationRequest);
    ApplicationResponse updateApplication(UUID applicationId, UpdateApplicationRequest updateApplicationRequest);
    void deleteApplication(UUID applicationId);
    ApplicationResponse getApplication(UUID applicationId);
    List<ApplicationResponse> getAllApplications();
}
