package card.transactions.domain.usecases.transaction.interfaces;

import card.transactions.domain.commands.TransactionCommand;

public interface TransactionCreateUseCase {
    TransactionCommand execute(TransactionCommand command);
}
