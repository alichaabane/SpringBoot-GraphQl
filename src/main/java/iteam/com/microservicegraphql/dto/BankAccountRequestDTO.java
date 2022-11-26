package iteam.com.microservicegraphql.dto;

import iteam.com.microservicegraphql.enumeration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private double balance;
    private String currency;
    private AccountType type;
}
