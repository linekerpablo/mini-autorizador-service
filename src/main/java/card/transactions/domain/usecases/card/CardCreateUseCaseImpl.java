package card.transactions.domain.usecases.card;

import card.transactions.domain.commands.CardCommand;
import card.transactions.domain.gateways.card.interfaces.CardCreateGateway;
import card.transactions.domain.usecases.card.interfaces.CardCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardCreateUseCaseImpl implements CardCreateUseCase {

    @Autowired
    private CardCreateGateway cardCreateGateway;

    @Override
    public CardCommand execute(CardCommand command) {
        return cardCreateGateway.execute(command);
    }
}
