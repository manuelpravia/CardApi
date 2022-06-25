package com.nttdata.card.domain.dto;



import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CreateCardRequest {

    @NotBlank
    private String type;
    @NotBlank
    private String idCredit;
    @NotNull
    private BigDecimal amount;
}
