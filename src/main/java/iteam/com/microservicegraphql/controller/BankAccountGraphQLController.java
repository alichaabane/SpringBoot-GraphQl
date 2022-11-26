package iteam.com.microservicegraphql.controller;

import iteam.com.microservicegraphql.dto.BankAccountRequestDTO;
import iteam.com.microservicegraphql.dto.BankAccountResponseDTO;
import iteam.com.microservicegraphql.entite.BankAccount;
import iteam.com.microservicegraphql.repository.BankAccountRepository;
import iteam.com.microservicegraphql.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class BankAccountGraphQLController {
    private final AccountService accountService;
    public BankAccountGraphQLController(AccountService accountService) {
        super();
        this.accountService = accountService;
    }
    @QueryMapping
    public List<BankAccountResponseDTO> accountsList(){
        return accountService.getAllAccount();
    }

    @QueryMapping
    public BankAccountResponseDTO getBankAccountById(@Argument String id) {
       return this.accountService.getAccountById(id);
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return this.accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return this.accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id) {
        this.accountService.deleteAccount(id);
    }

}
