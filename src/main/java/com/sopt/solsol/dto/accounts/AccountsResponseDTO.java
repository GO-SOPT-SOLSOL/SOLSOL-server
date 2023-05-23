package com.sopt.solsol.dto.accounts;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class AccountsResponseDTO {

    private Long id;
    private Long memberId;
    private String name;
    private String bank;
    private String kind;
    private String accountNumber;
    private Long balance;

    @Builder
    public AccountsResponseDTO(Long id, Long memberId, String name, String kind, String bank, String accountNumber, Long balance){
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.kind = kind;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

}
