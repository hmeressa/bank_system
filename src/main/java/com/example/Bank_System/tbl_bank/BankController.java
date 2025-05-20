package com.example.Bank_System.tbl_bank;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    private final BankInterface bankInterface;

    public BankController(BankInterface bankInterface) {
        this.bankInterface = bankInterface;
    }

    @PostMapping()
    public BankResponse createBank(@RequestBody CreateBankRequest createBankRequest) {
        return bankInterface.createBank(createBankRequest);
    }

    @GetMapping()
    public List<BankResponse> getBanks() {
        return bankInterface.getBanks();
    }

    @GetMapping("/{bankId}")
    public BankResponse getBank(@PathVariable UUID bankId) {
        return bankInterface.getBank(bankId);
    }

    @DeleteMapping("/{bankId}")
    public void deleteBank(@PathVariable UUID bankId) {
        bankInterface.deleteBank(bankId);
    }
}
