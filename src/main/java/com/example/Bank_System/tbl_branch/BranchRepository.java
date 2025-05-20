package com.example.Bank_System.tbl_branch;

import com.example.Bank_System.tbl_branch.Tbl_Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository()
public interface BranchRepository extends JpaRepository<Tbl_Branch, UUID> {
}
