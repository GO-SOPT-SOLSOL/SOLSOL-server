package com.sopt.solsol.common.dto.advice;

import com.sopt.solsol.common.dto.ApiResponseDto;
import com.sopt.solsol.exception.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControllerExceptionAdvice {
    /*
    ITERNAL SERVER ERROR
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResponseStatusException.class)
    protected ApiResponseDto handleResponseStatusException (final ResponseStatusException e){
        return ApiResponseDto.error(ErrorStatus.RESPONSE_STATUS_EXCEPTION);
    }
}
