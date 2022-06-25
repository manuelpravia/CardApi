package com.nttdata.card.infraestructure.data.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cards")
public class Card {

    @Id
    private String id;
    private String type;
    private String idCredit;
    private BigDecimal amount;
    @LastModifiedDate
    private LocalDateTime date;
}
