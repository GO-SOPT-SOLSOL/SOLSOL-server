package com.sopt.solsol.exception.model;


import com.sopt.solsol.exception.ErrorStatus;
import lombok.Getter;

@Getter
public class SolsolException extends RuntimeException{

    private final ErrorStatus errorStatus;

    public SolsolException(ErrorStatus errorStatus, String message) {
        super(message);
        this.errorStatus = errorStatus;
    }

    public int getHttpStatusCode() {
        return errorStatus.getHttpStatusCode();
    }
}
