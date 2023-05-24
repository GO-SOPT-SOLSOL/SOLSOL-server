package com.sopt.solsol.dto.transfer;

import lombok.Builder;
import lombok.Data;

@Data
public class TransferResponseDTO {
    private Long id;
    private Long accountsId;
    private String name;
    private String bank;
    private String accountNumber;
    private Long price;
    private String createdAt;

    @Builder

    public TransferResponseDTO(Long id, Long accountsId, String name, String bank, String accountNumber, Long price, String createdAt) {
        this.id = id;
        this.accountsId = accountsId;
        this.name = name;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.price = price;
        this.createdAt = createdAt;
    }
}
