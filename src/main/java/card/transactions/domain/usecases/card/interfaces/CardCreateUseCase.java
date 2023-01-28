package card.transactions.domain.usecases.card.interfaces;

import card.transactions.domain.commands.CardCommand;

public interface CardCreateUseCase {
    CardCommand execute(CardCommand command);
}
