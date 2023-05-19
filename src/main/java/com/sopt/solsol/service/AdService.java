package com.sopt.solsol.service;

import com.sopt.solsol.dto.accounts.AccountsResponseDTO;
import com.sopt.solsol.dto.ad.AdResponseDTO;
import com.sopt.solsol.repository.AccountsRepository;
import com.sopt.solsol.repository.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdService {
    private final AdRepository adRepository;

    @Transactional
    public List<AdResponseDTO> getAdList(){
        return adRepository.findAll()
                    .stream()
                    .map(ad -> AdResponseDTO.builder()
                            .id(ad.getId())
                            .title(ad.getTitle())
                            .content(ad.getContent())
                            .build())
                    .collect(Collectors.toList());
    }
}
