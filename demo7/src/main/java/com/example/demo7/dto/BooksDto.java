package com.example.demo7.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooksDto {

    private int id;

    @NotBlank
    private String shem;

    @NotBlank
    private int shana;
}
