package com.sopt.solsol.service;

import com.sopt.solsol.domain.Accounts;
import com.sopt.solsol.domain.Member;
import com.sopt.solsol.domain.Transfer;
import com.sopt.solsol.dto.transfer.TransferRequestDTO;
import com.sopt.solsol.dto.transfer.TransferResponseDTO;
import com.sopt.solsol.repository.AccountsRepository;
import com.sopt.solsol.repository.MemberRepository;
import com.sopt.solsol.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

        // 보내는 사람의 id
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("Member not found with id : " + memberId)
        );

        // 보내는 사람의 계좌
        Accounts senderAccounts = accountsRepository.findById(transferRequestDTO.getSenderAccountsId())
                        .orElseThrow(() -> new EntityNotFoundException());

        if (senderAccounts.getMember().getId() != memberId) {
            throw new IllegalArgumentException(memberId + "번 member는 " + transferRequestDTO.getSenderAccountsId() + "번 계좌의 소유자가 아닙니다.");
        }
        // 받는 사람의 계좌
        Accounts receiverAccounts = accountsRepository.findByBankAndNumber(transferRequestDTO.getBank(), transferRequestDTO.getNumber())
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
        List<Long> accountNumberList = new ArrayList<>();
        List<Transfer> transferList = transferRepository.findAllByMemberIdOrderByCreatedAtDesc(memberId);

        List<TransferResponseDTO> transferResponseDTOList = new ArrayList<>();
        for (Transfer transfer: transferList) {
            if( accountNumberList.contains(transfer.getAccounts().getId())) {
                continue;
            } else {
                transferResponseDTOList.add(
                        TransferResponseDTO.builder()
                                .id(transfer.getId())
                                .accountsId(transfer.getAccounts().getId())
                                .accountNumber(transfer.getAccounts().getNumber())
                                .bank(transfer.getAccounts().getBank().toString())
                                .name(transfer.getAccounts().getMember().getName())
                                .price(transfer.getPrice())
                                .createdAt(changeFormat(transfer.getCreatedAt()))
                                .build()
                );
                accountNumberList.add(transfer.getAccounts().getId());
            }
        }
        return transferResponseDTOList;
    }
    private String changeFormat(LocalDateTime localDateTime) {
         DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy.MM.dd");
            return localDateTime.format(formatter).toString();
    }
}
