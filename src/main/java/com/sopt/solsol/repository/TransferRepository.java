package com.sopt.solsol.repository;

import com.sopt.solsol.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

    void deleteByIdAndMemberId(Long transferId, Long memberId);

    List<Transfer> findAllByMemberIdOrderByCreatedAtDesc(Long memberId);
}
