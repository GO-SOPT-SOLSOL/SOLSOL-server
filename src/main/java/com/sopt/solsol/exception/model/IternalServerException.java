package com.sopt.solsol.exception.model;

import com.sopt.solsol.exception.ErrorStatus;

public class IternalServerException extends SolsolException{
    public IternalServerException(ErrorStatus error, String message)
    {
        super(error, message);
    }
}
