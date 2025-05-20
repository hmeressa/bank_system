package com.example.Bank_System.tbl_application;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateApplicationRequest {
    private String bank_name;
    private String branch_name;
    private String account_name;
    private String account_number;
    private String status;
}
