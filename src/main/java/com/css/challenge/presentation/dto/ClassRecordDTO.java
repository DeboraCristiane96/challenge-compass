package com.css.challenge.presentation.dto;


import jakarta.validation.constraints.NotBlank;

public record ClassRecordDTO(@NotBlank String name,@NotBlank String dataBegin,@NotBlank String dataEnd,@NotBlank String technology,@NotBlank String partners) {
}
