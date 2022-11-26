package iteam.com.microservicegraphql.service;

import iteam.com.microservicegraphql.dto.BankAccountRequestDTO;
import iteam.com.microservicegraphql.dto.BankAccountResponseDTO;
import iteam.com.microservicegraphql.entite.BankAccount;

import java.util.List;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
    public List<BankAccountResponseDTO> getAllAccount();
    public BankAccountResponseDTO getAccountById(String id);
    public void deleteAccount(String id);

}
