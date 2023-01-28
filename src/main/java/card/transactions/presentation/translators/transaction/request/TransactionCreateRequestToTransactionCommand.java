package card.transactions.presentation.translators.transaction.request;

import card.transactions.domain.commands.TransactionCommand;
import card.transactions.presentation.models.transaction.request.TransactionCreateRequest;

public class TransactionCreateRequestToTransactionCommand {
    public static TransactionCommand translate(TransactionCreateRequest request) {
        return request != null ?
                TransactionCommand.builder()
                        .number(request.getNumber())
                        .password(request.getPassword())
                        .value(request.getValue())
                        .build() : TransactionCommand.builder().build();
    }
}
