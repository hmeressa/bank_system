package com.example.Bank_System.tbl_application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository()
public interface ApplicationRepository extends JpaRepository<Tbl_Application, UUID> {
}
