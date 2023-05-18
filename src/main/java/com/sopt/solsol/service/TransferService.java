package com.sopt.solsol.service;

import com.sopt.solsol.dto.transfer.TransferResponseDTO;
import com.sopt.solsol.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;

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
                        .name(transfer.getAccounts().getName())
                        .createdAt(transfer.getCreatedAt().toString())
                        .build())
                .collect(Collectors.toList());

    }
}
