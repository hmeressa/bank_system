package com.example.Bank_System.tbl_application;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tbl_application")
public class Tbl_Application {
    @Id
    @GeneratedValue
    private UUID id;

    @Column()
    private String bank_name;
    private String branch_name;
    private String account_name;
    private String account_number;
    private String status;
}
