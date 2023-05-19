package com.sopt.solsol.repository;

import com.sopt.solsol.domain.Accounts;
import com.sopt.solsol.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByBankAndNumber(Bank bank, String number);
}
