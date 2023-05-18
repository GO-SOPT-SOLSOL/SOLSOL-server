package com.sopt.solsol.service;

import com.sopt.solsol.domain.Accounts;
import com.sopt.solsol.domain.Bank;
import com.sopt.solsol.domain.Member;
import com.sopt.solsol.domain.Transfer;
import com.sopt.solsol.dto.transfer.TransferRequestDTO;
import com.sopt.solsol.dto.transfer.TransferResponseDTO;
import com.sopt.solsol.repository.AccountsRepository;
import com.sopt.solsol.repository.MemberRepository;
import com.sopt.solsol.repository.TransferRepository;
import com.sopt.solsol.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;

    private final MemberRepository memberRepository;

    private final AccountsRepository accountsRepository;

    @Transactional
    public void create(TransferRequestDTO transferRequestDTO, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("Member not found with id : " + memberId)
        );
        Accounts senderAccounts = accountsRepository.findById(transferRequestDTO.getSenderAccountsId())
                        .orElseThrow(() -> new EntityNotFoundException());
        Bank bank = Util.getBankEnum(transferRequestDTO.getBank());
        Accounts receiverAccounts = accountsRepository.findByBankAndNumber(bank, transferRequestDTO.getNumber())
                        .orElseThrow(() -> new EntityNotFoundException());

        transferRepository.save(Transfer.builder()
                .member(member)
                .accounts(receiverAccounts)
                .createdAt(LocalDateTime.now())
                .transferMemo(transferRequestDTO.getTransferMemo())
                .receiverMemo(transferRequestDTO.getReceiverMemo())
                .charge(transferRequestDTO.getCharge())
                .price(transferRequestDTO.getPrice())
                .build());



        receiverAccounts.depositAccounts(transferRequestDTO.getPrice());
        senderAccounts.withdrawAccounts(transferRequestDTO.getPrice(), transferRequestDTO.getCharge());
    }

    @Transactional
    public void delete(Long transferId, Long memberId ) {
        transferRepository.deleteByIdAndMemberId(transferId, memberId);
    }

    @Transactional(readOnly = true)
    public List<TransferResponseDTO> getTransferList(Long memberId) {
        return transferRepository.findAllByMemberIdOrderByCreatedAtDesc(memberId)
                .stream()
                .map(transfer -> TransferResponseDTO.builder()
                        .id(transfer.getId())
                        .accountNumber(transfer.getAccounts().getNumber())
                        .bank(transfer.getAccounts().getBank().toString())
                        .name(transfer.getAccounts().getMember().getName())
                        .createdAt(changeFormat(transfer.getCreatedAt()))
                        .build())
                .collect(Collectors.toList());
    }

    private String changeFormat(LocalDateTime localDateTime) {
         DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy.MM.dd");
            return localDateTime.format(formatter).toString();
    }
}
