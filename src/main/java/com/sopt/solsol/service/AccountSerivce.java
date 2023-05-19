package com.sopt.solsol.service;

import com.sopt.solsol.domain.Accounts;
import com.sopt.solsol.dto.accounts.AccountsResponseDTO;
import com.sopt.solsol.dto.transfer.TransferResponseDTO;
import com.sopt.solsol.exception.ErrorStatus;
import com.sopt.solsol.repository.AccountsRepository;
import com.sopt.solsol.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountSerivce {
    private final AccountsRepository accountsRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public List<AccountsResponseDTO> getAccountList(Long memberId){

        memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));


        return   accountsRepository.findAllByMemberIdOrderByIdDesc(memberId)
                .stream()
                .map(accounts -> AccountsResponseDTO.builder()
                        .id(accounts.getId())
                        .memberId(accounts.getMember().getId())
                        .name(accounts.getName())
                        .bank(accounts.getBank().toString())
                        .accountNumber(accounts.getNumber())
                        .balance(accounts.getBalance())
                        .build())
                .collect(Collectors.toList());
    }

    public AccountsResponseDTO findOneByMemberIdAndId(Long memberId, Long accountId) {
        Accounts account = accountsRepository.findOneByMemberIdAndId(memberId, accountId);
        return AccountsResponseDTO.builder()
                .id(account.getId())
                .memberId(account.getMember().getId())
                .name(account.getName())
                .bank(account.getBank().toString())
                .accountNumber(account.getNumber())
                .balance(account.getBalance())
                .build();
    }


}
