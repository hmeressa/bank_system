package com.example.Bank_System.tbl_branch;

import com.example.Bank_System.tbl_bank.Tbl_Bank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tbl_branch")
public class Tbl_Branch {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String value;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bankId")
    private Tbl_Bank tbl_bank;
}
