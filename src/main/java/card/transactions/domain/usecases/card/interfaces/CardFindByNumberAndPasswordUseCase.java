package card.transactions.domain.usecases.card.interfaces;

import card.transactions.domain.commands.CardCommand;

import java.util.Optional;


public interface CardFindByNumberAndPasswordUseCase {
    Optional<CardCommand> execute(String cardNumber, String password);
}
