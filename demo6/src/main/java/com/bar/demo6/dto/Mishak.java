package com.bar.demo6.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mishak {

    private int id;

    @NotBlank
    private String shem;

    public Mishak(MishakPayloadDto mishakPayloadDto){
        this.shem = mishakPayloadDto.getShem();
    }
}
