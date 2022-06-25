package com.nttdata.card.domain.service;

import com.nttdata.card.exception.CardNotFoundException;
import com.nttdata.card.infraestructure.data.document.Card;
import com.nttdata.card.infraestructure.data.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Mono<Card> validateAndGetCard(String id) {
        return cardRepository.findById(id).switchIfEmpty(Mono.error(new CardNotFoundException(id)));
    }

    @Override
    public Flux<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Mono<Card> saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Mono<Void> deleteCard(Card card) {
        return cardRepository.delete(card);
    }
}
