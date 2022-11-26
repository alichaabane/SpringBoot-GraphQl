package iteam.com.microservicegraphql.service.impl;

import iteam.com.microservicegraphql.dto.BankAccountRequestDTO;
import iteam.com.microservicegraphql.dto.BankAccountResponseDTO;
import iteam.com.microservicegraphql.entite.BankAccount;
import iteam.com.microservicegraphql.mapper.AccountMapper;
import iteam.com.microservicegraphql.repository.BankAccountRepository;
import iteam.com.microservicegraphql.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepository bankAccountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository,
                              AccountMapper accountMapper) {
        super();
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;

    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountRepository.save(new BankAccount(
                UUID.randomUUID().toString(),
                bankAccountDTO.getBalance(),
                new Date(),
                bankAccountDTO.getCurrency(),
                bankAccountDTO.getType()));
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(saveBankAccount);

    }

    @Override
    public List<BankAccountResponseDTO> getAllAccount() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        if (bankAccounts.size() > 0) {
            return bankAccounts.stream().map(accountMapper::fromBankAccount).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public BankAccountResponseDTO getAccountById(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
        if (bankAccount != null) {
            return accountMapper.fromBankAccount(bankAccount);
        }
        return (null);
    }


    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountRepository.save(new BankAccount(
                id,
                bankAccountDTO.getBalance(),
                new Date(),
                bankAccountDTO.getCurrency(),
                bankAccountDTO.getType()));
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(saveBankAccount);

    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }


}
