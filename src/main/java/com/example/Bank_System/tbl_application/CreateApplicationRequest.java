package com.example.Bank_System.tbl_application;

import lombok.Getter;
@Getter
public class CreateApplicationRequest {
    private String bank_name;
    private String branch_name;
    private String account_name;
    private String account_number;
    private String status;
}
