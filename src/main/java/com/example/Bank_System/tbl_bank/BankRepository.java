package com.example.Bank_System.tbl_bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository()
public interface BankRepository extends JpaRepository<Tbl_Bank, UUID> {
}
