package card.transactions.domain.usecases.card;

import card.transactions.domain.commands.CardCommand;
import card.transactions.domain.gateways.card.interfaces.CardFindByNumberAndPasswordGateway;
import card.transactions.domain.usecases.card.interfaces.CardFindByNumberAndPasswordUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardFindByNumberAndPasswordUseCaseUseCaseImpl implements CardFindByNumberAndPasswordUseCase {
    @Autowired
    private CardFindByNumberAndPasswordGateway cardFindByNumberAndPasswordGateway;

    @Override
    public Optional<CardCommand> execute(String cardNumber, String password) {
        return cardFindByNumberAndPasswordGateway.execute(cardNumber, password);
    }
}
