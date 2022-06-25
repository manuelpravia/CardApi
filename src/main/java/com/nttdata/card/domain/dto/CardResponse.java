package com.nttdata.card.domain.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class CardResponse {
    private String id;
    private String type;
    private String idCredit;
    private BigDecimal amount;
    private LocalDateTime date;
}
