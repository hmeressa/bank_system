package com.example.Bank_System.tbl_branch;
import com.example.Bank_System.tbl_bank.CreateBranchRequest;
import com.example.Bank_System.tbl_bank.UpdateBranchRequest;
import com.example.Bank_System.tbl_branch.BranchInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/branch")
public class BranchController {

    private final BranchInterface branchInterface;

    public BranchController( BranchInterface branchInterface) {
        this.branchInterface = branchInterface;
    }

    @PostMapping()
    public BranchResponse createBranch(@RequestBody CreateBranchRequest createBranchRequest) {
        return branchInterface.createBranch(createBranchRequest);
    }

    @GetMapping()
    public List<BranchResponse> getBranches() {
        return branchInterface.getBranches();
    }

    @GetMapping("/{branchId}")
    public BranchResponse getBank(@PathVariable UUID branchId) {
        return branchInterface.getBranch(branchId);
    }

    @DeleteMapping("/{branchId}")
    public void deleteBranch(@PathVariable UUID branchId) {
        branchInterface.deleteBranch(branchId);
    }

    @PutMapping("/{branchId}")
    public BranchResponse updateBank(@PathVariable UUID branchId, @RequestBody UpdateBranchRequest updateBranchRequest) {
      return branchInterface.updateBranch(branchId, updateBranchRequest);
    }

}
