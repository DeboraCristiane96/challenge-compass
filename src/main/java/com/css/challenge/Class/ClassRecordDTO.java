package com.css.challenge.Class;


import jakarta.validation.constraints.NotBlank;

public record ClassRecordDTO(@NotBlank String name,@NotBlank String dataBegin,@NotBlank String dataEnd,@NotBlank String technology,@NotBlank String partners) {
}
