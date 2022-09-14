package com.example.demo7.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AuthorDto {

    private int id;

    @NotBlank
    private String shem;

    @NotBlank
    private List<BooksDto> booksDtoList;

}
