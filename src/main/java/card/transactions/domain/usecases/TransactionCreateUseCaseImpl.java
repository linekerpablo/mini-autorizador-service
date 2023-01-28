package card.transactions.domain.usecases;

import card.transactions.domain.commands.TransactionCommand;
import card.transactions.domain.gateways.transaction.interfaces.TransactionCreateGateway;
import card.transactions.domain.usecases.transaction.interfaces.TransactionCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCreateUseCaseImpl implements TransactionCreateUseCase {

    @Autowired
    private TransactionCreateGateway transactionCreateGateway;

    @Override
    public TransactionCommand execute(TransactionCommand command) {
        return transactionCreateGateway.execute(command);
    }
}
