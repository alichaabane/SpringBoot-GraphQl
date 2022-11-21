package iteam.com.microservicegraphql.entite;

import iteam.com.microservicegraphql.enumeration.AccountType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private double balance ;
    private Date createdAt ;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
