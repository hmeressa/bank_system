package com.example.Bank_System.tbl_application.service;

import com.example.Bank_System.tbl_application.*;
import com.example.Bank_System.tbl_application.ApplicationInterface;
import com.example.Bank_System.tbl_application.CreateApplicationRequest;
import com.example.Bank_System.tbl_application.Tbl_Application;
import com.example.Bank_System.tbl_application.UpdateApplicationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationInterface {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public ApplicationResponse createApplication(CreateApplicationRequest createApplicationRequest) {
         Tbl_Application tbl_Application = new Tbl_Application();
         tbl_Application.setBank_name(createApplicationRequest.getBank_name());
         tbl_Application.setAccount_name(createApplicationRequest.getAccount_name());
         tbl_Application.setAccount_number(createApplicationRequest.getAccount_number());
         tbl_Application.setStatus(createApplicationRequest.getStatus());
         Tbl_Application tblApplication = applicationRepository.save(tbl_Application);
         return mapApplicationResponse(tblApplication);
    }

    @Override
    public ApplicationResponse updateApplication(UUID applicationId, UpdateApplicationRequest updateApplicationRequest) {
        Tbl_Application tblApplication = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        tblApplication.setBranch_name(updateApplicationRequest.getBranch_name());
        tblApplication.setBank_name(updateApplicationRequest.getBank_name());
        tblApplication.setAccount_number(updateApplicationRequest.getAccount_number());
        Tbl_Application savedApplication = applicationRepository.save(tblApplication);
        return mapApplicationResponse(savedApplication);
    }

    @Override
    public void deleteApplication(UUID applicationId) {
        applicationRepository.findById(applicationId).orElseThrow(()->new RuntimeException("Application Not found"));
        applicationRepository.deleteById(applicationId);
    }

    @Override
    public ApplicationResponse getApplication(UUID applicationId) {
        Tbl_Application tblApplication = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        return mapApplicationResponse(tblApplication);
    }

    @Override
    public List<ApplicationResponse> getAllApplications() {
        return applicationRepository.findAll()
                .stream()
                .map(this::mapApplicationResponse)
                .collect(Collectors.toList());
    }

    private ApplicationResponse mapApplicationResponse(Tbl_Application tblApplication) {
        ApplicationResponse applicationResponse = new ApplicationResponse();
        applicationResponse.setId(tblApplication.getId());
        return applicationResponse;
    }
}
