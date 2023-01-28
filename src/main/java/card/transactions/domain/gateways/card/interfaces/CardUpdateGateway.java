package card.transactions.domain.gateways.card.interfaces;

import card.transactions.domain.commands.CardCommand;

public interface CardUpdateGateway {
    CardCommand execute(CardCommand command);
}
