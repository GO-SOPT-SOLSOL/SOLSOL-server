package com.sopt.solsol.controller;

import com.sopt.solsol.common.dto.ApiResponseDto;
import com.sopt.solsol.dto.transfer.TransferResponseDTO;
import com.sopt.solsol.service.TransferService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sopt.solsol.common.dto.ApiResponseDto.*;
import static com.sopt.solsol.exception.SuccessStatus.*;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @DeleteMapping("/{transferId}")
    public ResponseEntity<ApiResponseDto> deleteTransfer(
            @PathVariable("transferId") Long transferId,
            @RequestParam("memberId") Long memberId
    ) {
        transferService.delete(transferId, memberId);
        return ResponseEntity.ok(success(DELETE_RECEIVER_SUCCESS));
    }

    @GetMapping()
    public ResponseEntity<ApiResponseDto> getTransferList(
            @RequestParam("memberId") Long memberId
    ) {
        List<TransferResponseDTO> transfers = transferService.getTransferList(memberId);
        TransferResponseDto transferResponseDto = new TransferResponseDto(transfers);
        return ResponseEntity.ok(success(GET_RECEIVER_SUCCESS, transferResponseDto));
    }

    @Data
    @Builder
    public static class TransferResponseDto {
        private List<TransferResponseDTO> feedback;
    }
}
