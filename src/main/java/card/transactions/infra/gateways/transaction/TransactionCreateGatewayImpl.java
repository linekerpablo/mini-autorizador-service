package card.transactions.infra.gateways.transaction;

import card.transactions.domain.commands.TransactionCommand;
import card.transactions.domain.gateways.transaction.interfaces.TransactionCreateGateway;
import card.transactions.infra.repositories.TransactionRepository;
import card.transactions.infra.translators.transaction.TransactionCommandToTransaction;
import card.transactions.infra.translators.transaction.TransactionToTransactionCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCreateGatewayImpl implements TransactionCreateGateway {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionCommand execute(TransactionCommand command) {
        return TransactionToTransactionCommand.translate(transactionRepository.save(TransactionCommandToTransaction.translate(command)));
    }
}
