package com.nttdata.card.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateCardRequest {

    private String type;
    private String idCredit;
    private BigDecimal amount;

}
