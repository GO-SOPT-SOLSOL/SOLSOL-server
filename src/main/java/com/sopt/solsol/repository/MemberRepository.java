package com.sopt.solsol.repository;

import com.sopt.solsol.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
