package com.bar.demo6.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hatol {
    private int id;

    @NotBlank
    private String shem;

    @NotBlank
    private float miskal;

    @NotBlank
    private List<Mishak> mishakim;

    public Hatol(HatolPayloadDto hatolPayloadDto){
        this.shem = hatolPayloadDto.getShem();
        this.miskal = hatolPayloadDto.getMishkal();
        this.mishakim = hatolPayloadDto.getMishakim();
    }
}
