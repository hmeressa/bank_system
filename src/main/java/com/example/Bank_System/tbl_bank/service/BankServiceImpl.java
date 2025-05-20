package com.example.Bank_System.tbl_bank.service;

import com.example.Bank_System.tbl_bank.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankInterface {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public BankResponse createBank(CreateBankRequest createBankRequest) {
        Tbl_Bank tblBank = new Tbl_Bank();
        tblBank.setValue(createBankRequest.getValue());
        Tbl_Bank savedBank = bankRepository.save(tblBank);
        return mapBankResponse(savedBank);
    }


    @Override
    public List<BankResponse> getBanks() {
        return bankRepository.findAll()
                .stream()
                .map(this::mapBankResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BankResponse getBank(UUID bankId) {
        Tbl_Bank tblBank = bankRepository.findById(bankId)
                .orElseThrow(() -> new RuntimeException("Bank not found"));
        return mapBankResponse(tblBank);
    }

    @Override
    public void deleteBank(UUID bankId) {
        bankRepository.findById(bankId).orElseThrow(()->new RuntimeException("Bank Not found"));
        bankRepository.deleteById(bankId);
    }

    private BankResponse mapBankResponse(Tbl_Bank tblBank) {
        BankResponse bankResponse = new BankResponse();
        bankResponse.setId(tblBank.getId());
        bankResponse.setValue(tblBank.getValue());
        return bankResponse;
    }
}
