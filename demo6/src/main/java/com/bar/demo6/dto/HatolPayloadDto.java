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
public class HatolPayloadDto {

    @NotBlank
    private String shem;

    @NotBlank
    private float mishkal;

    @NotBlank
    private List<Mishak> mishakim;
}
