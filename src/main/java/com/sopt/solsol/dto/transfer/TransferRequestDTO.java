package com.sopt.solsol.dto.transfer;

import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class TransferRequestDTO {
    private Long senderAccountsId;
    private String transferMemo;
    private String receiverMemo;
    private String bank;
    private String number;
    @PositiveOrZero
    private Long charge;
    @Positive
    private Long price;
}