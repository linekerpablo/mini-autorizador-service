package card.transactions.domain.usecases.transaction;

import card.transactions.domain.commands.TransactionCommand;
import card.transactions.domain.gateways.transaction.interfaces.TransactionCreateGateway;
import card.transactions.domain.usecases.card.interfaces.CardValidateTransactionUseCase;
import card.transactions.domain.usecases.transaction.interfaces.TransactionCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCreateUseCaseImpl implements TransactionCreateUseCase {

    @Autowired
    private TransactionCreateGateway transactionCreateGateway;

    @Autowired
    private CardValidateTransactionUseCase cardValidateTransactionUseCase;

    @Override
    public TransactionCommand execute(TransactionCommand command) {
        cardValidateTransactionUseCase.execute(command);

        return transactionCreateGateway.execute(command);
    }
}
