package com.example.Bank_System.tbl_bank;

import java.util.List;
import java.util.UUID;

public interface BankInterface {
    BankResponse createBank(CreateBankRequest createBankRequest);
    List<BankResponse> getBanks();
    BankResponse getBank(UUID bankId);
    void deleteBank(UUID bankId);
}
