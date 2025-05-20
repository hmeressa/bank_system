package com.example.Bank_System.tbl_bank;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BankResponse {
    private UUID id;
    private String value;
}
