package com.sopt.solsol.dto.ad;

import lombok.Builder;
import lombok.Data;

@Data
public class AdResponseDTO {

    private Long id;
    private String title;
    private String content;

    @Builder
    public AdResponseDTO(Long id, String title,String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
