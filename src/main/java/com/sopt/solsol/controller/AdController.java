package com.sopt.solsol.controller;

import com.sopt.solsol.common.dto.ApiResponseDto;
import static com.sopt.solsol.common.dto.ApiResponseDto.success;
import com.sopt.solsol.dto.accounts.AccountsResponseDTO;
import com.sopt.solsol.dto.ad.AdResponseDTO;
import com.sopt.solsol.dto.transfer.TransferRequestDTO;
import com.sopt.solsol.exception.SuccessStatus;
import com.sopt.solsol.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ads")
@RequiredArgsConstructor
public class AdController {
    private final AdService adService;

    @GetMapping()
    public ResponseEntity<ApiResponseDto> getAdList() {

        List<AdResponseDTO> ads = adService.getAdList();

        return ResponseEntity.ok(success(SuccessStatus.GET_AD_SUCCESS, ads));
    }

}
