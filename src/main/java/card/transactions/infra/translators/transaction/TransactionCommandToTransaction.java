package card.transactions.infra.translators.transaction;

import card.transactions.domain.commands.TransactionCommand;
import card.transactions.infra.entities.Transaction;

public class TransactionCommandToTransaction {
    public static Transaction translate(TransactionCommand command) {
        return command != null ?
                Transaction.builder()
                        .number(command.getNumber())
                        .password(command.getPassword())
                        .value(command.getValue())
                        .createdAt(command.getCreatedAt())
                        .deleted(command.isDeleted())
                        .deletedIn(command.getDeletedIn())
                        .active(command.isActive())
                        .build() : Transaction.builder().build();
    }
}
