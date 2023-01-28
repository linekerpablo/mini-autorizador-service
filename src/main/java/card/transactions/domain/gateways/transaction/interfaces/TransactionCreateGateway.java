package card.transactions.domain.gateways.transaction.interfaces;

import card.transactions.domain.commands.TransactionCommand;

public interface TransactionCreateGateway {
    TransactionCommand execute(TransactionCommand command);
}
