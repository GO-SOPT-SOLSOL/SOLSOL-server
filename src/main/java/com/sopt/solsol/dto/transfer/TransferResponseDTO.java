package com.sopt.solsol.dto.transfer;

import lombok.Builder;
import lombok.Data;

@Data
public class TransferResponseDTO {
    private Long id;
    private String name;
    private String bank;
    private String accountNumber;
    private String createdAt;

    @Builder
    public TransferResponseDTO(Long id, String name, String bank, String accountNumber, String createdAt) {
        this.id = id;
        this.name = name;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
    }
}
