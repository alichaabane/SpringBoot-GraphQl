package iteam.com.microservicegraphql;

import iteam.com.microservicegraphql.entite.BankAccount;
import iteam.com.microservicegraphql.enumeration.AccountType;
import iteam.com.microservicegraphql.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroServiceGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceGraphQlApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository) {
        return args -> {
          for(int i= 1; i < 10; i++) {
              BankAccount bankAccount = BankAccount.builder()
                      .id(UUID.randomUUID().toString())
                      .type(Math.random() >0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                      .createdAt(new Date())
                      .currency("DT")
                      .build();
              bankAccountRepository.save(bankAccount);
          }
        };
    }

}
