package card.transactions.domain.usecases.transaction.interfaces;

import card.transactions.domain.commands.CardCommand;
import card.transactions.domain.commands.TransactionCommand;

public interface TransactionValidateBalanceCardUseCase {
    CardCommand execute(TransactionCommand command);
}
