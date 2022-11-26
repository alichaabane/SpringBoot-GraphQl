package iteam.com.microservicegraphql.dto;

import iteam.com.microservicegraphql.enumeration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private String currency;
    private AccountType type;
}
