package card.transactions.domain.gateways.card.interfaces;

import card.transactions.domain.commands.CardCommand;

import java.util.Optional;

public interface CardFindByNumberGateway {
    Optional<CardCommand> execute(String number);
}