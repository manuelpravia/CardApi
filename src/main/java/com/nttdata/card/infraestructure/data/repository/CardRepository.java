package com.nttdata.card.infraestructure.data.repository;

import com.nttdata.card.infraestructure.data.document.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CardRepository extends ReactiveMongoRepository<Card,String> {
}
