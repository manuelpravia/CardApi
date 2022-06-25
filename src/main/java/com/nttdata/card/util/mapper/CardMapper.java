package com.nttdata.card.util.mapper;

import com.nttdata.card.domain.dto.CardResponse;
import com.nttdata.card.domain.dto.CreateCardRequest;
import com.nttdata.card.domain.dto.UpdateCardRequest;
import com.nttdata.card.infraestructure.data.document.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CardMapper {

    @Mapping(target = "id", ignore = true)
    Card toCard(CreateCardRequest createCardRequest);

    CardResponse toCardResponse(Card card);

    @Mapping(target = "id", ignore = true)
    void updateCardFromRequest(UpdateCardRequest updateCardRequest, @MappingTarget Card card);
}
