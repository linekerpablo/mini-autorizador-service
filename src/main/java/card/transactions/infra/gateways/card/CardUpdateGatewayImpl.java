package card.transactions.infra.gateways.card;

import card.transactions.domain.commands.CardCommand;
import card.transactions.domain.gateways.card.interfaces.CardCreateGateway;
import card.transactions.domain.gateways.card.interfaces.CardUpdateGateway;
import card.transactions.infra.repositories.CardRepository;
import card.transactions.infra.translators.card.CardCommandToCard;
import card.transactions.infra.translators.card.CardToCardCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardUpdateGatewayImpl implements CardUpdateGateway {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public CardCommand execute(CardCommand command) {
        var card = CardCommandToCard.translate(command);
        card.setId(command.getId());

        return CardToCardCommand.translate(cardRepository.save(card));
    }
}
