package card.transactions.infra.translators.transaction;

import card.transactions.domain.commands.TransactionCommand;
import card.transactions.infra.entities.Transaction;

public class TransactionToTransactionCommand {
    public static TransactionCommand translate(Transaction transaction) {
        return transaction != null ?
                TransactionCommand.builder()
                        .id(transaction.getId())
                        .number(transaction.getNumber())
                        .password(transaction.getPassword())
                        .value(transaction.getValue())
                        .build() : null;
    }
}
