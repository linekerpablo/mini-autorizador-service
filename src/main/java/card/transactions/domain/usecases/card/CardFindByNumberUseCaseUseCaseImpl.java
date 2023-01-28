package card.transactions.domain.usecases.card;

import card.transactions.domain.commands.CardCommand;
import card.transactions.domain.gateways.card.interfaces.CardFindByNumberGateway;
import card.transactions.domain.usecases.card.interfaces.CardFindByNumberUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardFindByNumberUseCaseUseCaseImpl implements CardFindByNumberUseCase {
    @Autowired
    private CardFindByNumberGateway cardFindByNumberGateway;

    @Override
    public Optional<CardCommand> execute(String number) {

        return cardFindByNumberGateway.execute(number);
    }
}
