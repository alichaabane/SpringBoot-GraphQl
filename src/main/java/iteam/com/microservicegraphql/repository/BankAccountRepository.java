package iteam.com.microservicegraphql.repository;

import iteam.com.microservicegraphql.entite.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
