package card.transactions.domain.usecases.card.interfaces;

import card.transactions.domain.commands.TransactionCommand;

public interface CardValidateTransactionUseCase {
    void execute(TransactionCommand command);
}
