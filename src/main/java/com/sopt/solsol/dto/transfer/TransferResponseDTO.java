package com.sopt.solsol.dto.transfer;

import lombok.Builder;
import lombok.Data;

@Data
public class TransferResponseDTO {
    private Long id;
    private Long memberId;
    private String name;
    private String bank;
    private String accountNumber;
    private Long price;
    private String createdAt;

    @Builder

    public TransferResponseDTO(Long id, Long memberId, String name, String bank, String accountNumber, Long price, String createdAt) {
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.price = price;
        this.createdAt = createdAt;
    }
}
