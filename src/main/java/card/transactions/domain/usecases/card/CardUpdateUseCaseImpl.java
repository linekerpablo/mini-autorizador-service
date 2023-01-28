package card.transactions.domain.usecases.card;

import card.transactions.domain.commands.CardCommand;
import card.transactions.domain.gateways.card.interfaces.CardCreateGateway;
import card.transactions.domain.gateways.card.interfaces.CardUpdateGateway;
import card.transactions.domain.usecases.card.interfaces.CardCreateUseCase;
import card.transactions.domain.usecases.card.interfaces.CardFindByNumberUseCase;
import card.transactions.domain.usecases.card.interfaces.CardUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardUpdateUseCaseImpl implements CardUpdateUseCase {

    @Autowired
    private CardUpdateGateway cardUpdateGateway;

    @Override
    public CardCommand execute(CardCommand command) {

        return cardUpdateGateway.execute(command);
    }
}
