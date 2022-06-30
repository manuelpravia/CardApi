package com.nttdata.card.api;

import com.nttdata.card.domain.dto.CardResponse;
import com.nttdata.card.domain.dto.CreateCardRequest;
import com.nttdata.card.domain.dto.UpdateCardRequest;
import com.nttdata.card.domain.service.CardService;
import com.nttdata.card.infraestructure.data.document.Card;
import com.nttdata.card.util.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("cards")
public class CardApi {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardMapper cardMapper;

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<CardResponse> getCards(){
        return cardService.getCards().map(cardMapper::toCardResponse);
    }

    @GetMapping("/{id}")
    public Mono<CardResponse> getCard(@PathVariable String id){
        return cardService.validateAndGetCard(id).map(cardMapper::toCardResponse);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<CardResponse> createCard(@Valid @RequestBody CreateCardRequest createCardRequest) {
        Card customer = cardMapper.toCard(createCardRequest);
        return cardService.saveCard(customer).map(cardMapper::toCardResponse);
    }

    @PatchMapping("/{id}")
    public Mono<CardResponse> updateCard(@PathVariable String id,
                                                 @RequestBody UpdateCardRequest updateCardRequest) {
        return cardService.validateAndGetCard(id)
                .doOnSuccess(card -> {
                    cardMapper.updateCardFromRequest(updateCardRequest, card);
                    cardService.saveCard(card).subscribe();
                })
                .map(cardMapper::toCardResponse);
    }

    @DeleteMapping("/{id}")
    public Mono<CardResponse> deleteCard(@PathVariable String id) {
        return cardService.validateAndGetCard(id)
                .doOnSuccess(card -> cardService.deleteCard(card).subscribe())
                .map(cardMapper::toCardResponse);
    }
}
