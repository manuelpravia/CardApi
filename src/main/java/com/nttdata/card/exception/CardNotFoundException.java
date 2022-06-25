package com.nttdata.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardNotFoundException extends RuntimeException{

    public CardNotFoundException(String id){
        super(String.format("Card with %s not found",id));
    }
}
