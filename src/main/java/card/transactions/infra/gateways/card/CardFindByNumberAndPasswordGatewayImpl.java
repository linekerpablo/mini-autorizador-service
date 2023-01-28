package card.transactions.infra.gateways.card;

import card.transactions.domain.commands.CardCommand;
import card.transactions.domain.gateways.card.interfaces.CardFindByNumberAndPasswordGateway;
import card.transactions.domain.gateways.card.interfaces.CardFindByNumberGateway;
import card.transactions.infra.repositories.CardRepository;
import card.transactions.infra.translators.card.CardToCardCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardFindByNumberAndPasswordGatewayImpl implements CardFindByNumberAndPasswordGateway {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public Optional<CardCommand> execute(String cardNumber, String password) {
        return Optional.ofNullable(CardToCardCommand.translate(cardRepository.findByNumberAndPassword(cardNumber, password)));
    }
}
