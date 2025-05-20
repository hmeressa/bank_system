package com.example.Bank_System.tbl_branch.service;
import com.example.Bank_System.tbl_branch.CreateBranchRequest;

import com.example.Bank_System.tbl_bank.UpdateBranchRequest;
import com.example.Bank_System.tbl_branch.BranchInterface;
import com.example.Bank_System.tbl_branch.BranchRepository;
import com.example.Bank_System.tbl_branch.BranchResponse;
import com.example.Bank_System.tbl_branch.Tbl_Branch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchInterface {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public BranchResponse createBranch(CreateBranchRequest createBankRequest) {
        Tbl_Branch tblBank = new Tbl_Branch();
        tblBank.setValue(createBankRequest.getValue());
        Tbl_Branch savedBank = branchRepository.save(tblBank);
        return mapBranchResponse(savedBank);
    }

    @Override
    public List<BranchResponse> getBranches() {
        return branchRepository.findAll()
                .stream()
                .map(this::mapBranchResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BranchResponse getBranch(UUID branchId) {
        Tbl_Branch tblApplication = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        return mapBranchResponse(tblApplication);
    }

    @Override
    public BranchResponse updateBranch(UUID branchId, UpdateBranchRequest updateBranchRequest) {
        return null;
    }

    @Override
    public void deleteBranch(UUID branchId) {

    }

    private BranchResponse mapBranchResponse(Tbl_Branch tbl_branch) {
        BranchResponse bankResponse = new BranchResponse();
        bankResponse.setId(tbl_branch.getId());
        bankResponse.setValue(tbl_branch.getValue());
        return bankResponse;
    }
}
