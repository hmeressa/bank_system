package com.example.Bank_System.tbl_application;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ApplicationResponse {
    private UUID id;
    private String bank_name;
    private String branch_name;
    private String account_name;
    private String account_number;
    private String status;
}
