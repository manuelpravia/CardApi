package com.nttdata.card.domain.service;

import com.nttdata.card.infraestructure.data.document.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {

    Mono<Card> validateAndGetCard(String id);

    Flux<Card> getCards();

    Mono<Card> saveCard(Card card);

    Mono<Void> deleteCard(Card card);
}
