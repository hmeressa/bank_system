package com.example.Bank_System.tbl_branch;

import com.example.Bank_System.tbl_branch.CreateBranchRequest;
import com.example.Bank_System.tbl_bank.UpdateBranchRequest;

import java.util.List;
import java.util.UUID;

public interface BranchInterface {
    BranchResponse createBranch(CreateBranchRequest createBranchRequest);
    List<BranchResponse> getBranches();
    BranchResponse getBranch(UUID branchId);
    BranchResponse updateBranch(UUID branchId, UpdateBranchRequest updateBranchRequest);
    void deleteBranch(UUID branchId);

}
