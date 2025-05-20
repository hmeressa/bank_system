package com.example.Bank_System.tbl_bank;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tbl_bank")
public class Tbl_Bank {
    @Id
    @GeneratedValue
    private UUID id;

    @Column()
    private String value;
}
