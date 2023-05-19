package com.sopt.solsol.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.Access;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {
    /*
    400 BAD_REQUEST
     */

    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "이체를 실패했습니다."),
    VALIDATION_MEMBER_ID_EXCEPTION(HttpStatus.BAD_REQUEST, "멤버 id가 입력되지 않았습니다."),
    VALIDATION_ACCOUNT_ID_EXCEPTION(HttpStatus.BAD_REQUEST, "계좌 id가 입력되지 않았습니다."),
    VALIDATION_AD_ID_EXCEPTION(HttpStatus.BAD_REQUEST, "광고 id가 입력되지 않았습니다."),

      /*
    401 UNAUTHORIZED
     */

    UNAUTHORIZED_MEMBER_EXCEPTION(HttpStatus.UNAUTHORIZED, "유효하지 않은 회원 입니다."),

    /*
    CONFLICT
     */

    CONFLICT_ACCOUNT_EXCEPTION(HttpStatus.CONFLICT, "이미 등록된 계좌 입니다."),

    /*
    SERVER_ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러가 발생했습니다."),
    BAD_GATEWAY_EXCEPTION(HttpStatus.BAD_GATEWAY, "일시적인 에러가 발생하였습니다.\n잠시 후 다시 시도해주세요!"),
    SERVICE_UNAVAILABLE_EXCEPTION(HttpStatus.SERVICE_UNAVAILABLE, "현재 점검 중입니다.\n잠시 후 다시 시도해주세요!"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
