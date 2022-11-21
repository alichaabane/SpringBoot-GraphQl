package iteam.com.microservicegraphql.controller;

import iteam.com.microservicegraphql.entite.BankAccount;
import iteam.com.microservicegraphql.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private final BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAccounts/{id}")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        if(bankAccount.getBalance() != 0.0) bankAccount.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAt()!= null) bankAccount.setCreatedAt(bankAccount.getCreatedAt());
        if(bankAccount.getType()!= null) bankAccount.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!= null) bankAccount.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElseThrow(null);
        System.out.println(bankAccount.getBalance());
        System.out.println(account.getBalance());
        if (bankAccount.getBalance() != 0.0) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt() != null) account.setCreatedAt(bankAccount.getCreatedAt());
        if (bankAccount.getType() != null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

        @DeleteMapping("/bankAccounts/{id}")
        public void delete(@PathVariable String id){
            bankAccountRepository.deleteById(id);
        }
}
