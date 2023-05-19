package com.sopt.solsol.repository;

import com.sopt.solsol.domain.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sopt.solsol.domain.Bank;
import java.util.List;

import java.util.Optional;


public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    // Create

    // Read
    List<Accounts> findAllByMemberIdOrderByIdDesc(Long memberId);                         // 해당 멤버의 계좌 모두 조회

    Accounts findOneByMemberIdAndId(Long memberId, Long id);                 // 해당 멤버의 계좌 단건 조회

    Optional<Accounts> findByBankAndNumber(Bank bank, String number);

    // Update


    // Delete
}
