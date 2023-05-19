package com.sopt.solsol.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopt.solsol.exception.ErrorStatus;
import com.sopt.solsol.exception.SuccessStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.*;
import static lombok.AccessLevel.*;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@JsonInclude(Include.NON_NULL)
public class ApiResponseDto<T> {

    private final int status;
    private final boolean success;
    private final String message;
    private T data;

    public static ApiResponseDto success(SuccessStatus successStatus) {
        return new ApiResponseDto<>(successStatus.getHttpStatus().value(), true, successStatus.getMessage());
    }

    public static <T> ApiResponseDto<T> success(SuccessStatus successStatus, T data) {
        return new ApiResponseDto<T>(successStatus.getHttpStatus().value(), true, successStatus.getMessage(), data);
    }

    public static ApiResponseDto error(ErrorStatus errorStatus) {
        return new ApiResponseDto<>(errorStatus.getHttpStatus().value(), false, errorStatus.getMessage());
    }
}
