package com.sopt.solsol.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.Access;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    /*
    Transfer
     */
    TRANSFER_SUCCESS(HttpStatus.OK, "송금이 완료되었습니다."),

    GET_RECEIVER_SUCCESS(HttpStatus.OK, "최근 보낸사람 목록을 조회했습니다."),

    DELETE_RECEIVER_SUCCESS(HttpStatus.OK, "성공적으로 삭제했습니다."),

    /*
    Ads
     */

    GET_AD_SUCCESS(HttpStatus.OK, "광고 조회에 성공했습니다."),


    /*
    Accounts
     */
    GET_ACCOUNT_SUCCESS(HttpStatus.OK, "계좌 단건 조회에 성공했습니다."),

    GET_ACCOUNTS_SUCCESS(HttpStatus.OK, "계좌 목록 조회에 성공했습니다."),

    GER_ADS_SUCCESS(HttpStatus.OK, "광고 목록 조회에 성공했습니다.");


    private final HttpStatus httpStatus;
    private final String message;
}