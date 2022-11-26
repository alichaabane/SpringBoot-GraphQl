package iteam.com.microservicegraphql.controller;

import iteam.com.microservicegraphql.dto.BankAccountRequestDTO;
import iteam.com.microservicegraphql.dto.BankAccountResponseDTO;
import iteam.com.microservicegraphql.entite.BankAccount;
import iteam.com.microservicegraphql.repository.BankAccountRepository;
import iteam.com.microservicegraphql.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccounts() {
        return accountService.getAllAccount();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO bankAccount(@PathVariable String id) {
        return this.accountService.getAccountById(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccount) {
        return this.accountService.addAccount(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO update(@PathVariable String id, @RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
      return this.accountService.updateAccount(id, bankAccountRequestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        this.accountService.deleteAccount(id);

    }
}
