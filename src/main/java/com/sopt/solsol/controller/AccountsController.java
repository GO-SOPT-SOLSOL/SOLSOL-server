package com.sopt.solsol.controller;


import com.sopt.solsol.common.dto.ApiResponseDto;
import com.sopt.solsol.dto.accounts.AccountsResponseDTO;
import com.sopt.solsol.service.AccountSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sopt.solsol.common.dto.ApiResponseDto.success;
import static com.sopt.solsol.exception.SuccessStatus.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountSerivce accountSerivce;


    @GetMapping("/")
    public ResponseEntity<ApiResponseDto> getAccountsList(
            @RequestParam("memberId") Long memberId
    ){
        List<AccountsResponseDTO> accounts = accountSerivce.getAccountList(memberId);

        return ResponseEntity.ok(success(GET_ACCOUNTS_SUCCESS, accounts));

    }

    @GetMapping("/{accountsId}")
    public ResponseEntity<ApiResponseDto> getAccount(
            @PathVariable("accountsId") Long accountsId,
            @RequestParam("memberId") Long memberId
    ){
        AccountsResponseDTO account = accountSerivce.findOneByMemberIdAndId(memberId, accountsId);

        return  ResponseEntity.ok(success(GET_ACCOUNT_SUCCESS, account));

    }


}